package expenses

import (
	"errors"
	"fmt"
)

// Record represents an expense record.
type Record struct {
	Day      int
	Amount   float64
	Category string
}

// DaysPeriod represents a period of days for expenses.
type DaysPeriod struct {
	From int
	To   int
}

// Filter returns the records for which the predicate function returns true.
func Filter(in []Record, predicate func(Record) bool) []Record {
	var filtered []Record
	for _, r := range in {
		if predicate(r) {
			filtered = append(filtered, r)
		}
	}
	return filtered
}

// ByDaysPeriod returns a predicate function for filtering by date range.
func ByDaysPeriod(p DaysPeriod) func(Record) bool {
	return func(r Record) bool {
		return r.Day >= p.From && r.Day <= p.To
	}
}

// ByCategory returns a predicate function for filtering by category.
func ByCategory(c string) func(Record) bool {
	return func(r Record) bool {
		return r.Category == c
	}
}

// TotalByPeriod returns total amount of expenses for records in a given period.
func TotalByPeriod(in []Record, p DaysPeriod) float64 {
	var total float64
	periodFilter := ByDaysPeriod(p)
	for _, r := range in {
		if periodFilter(r) {
			total += r.Amount
		}
	}
	return total
}

// CategoryExpenses returns total expenses for a category in a given period.
// Returns error only if category is not found in records.
func CategoryExpenses(in []Record, p DaysPeriod, c string) (float64, error) {
	// First, check if the category exists at all
	foundCategory := false
	for _, r := range in {
		if r.Category == c {
			foundCategory = true
			break
		}
	}
	if !foundCategory {
		return 0, errors.New(fmt.Sprintf("unknown category %s", c))
	}

	// Filter by both category and period
	categoryFilter := ByCategory(c)
	periodFilter := ByDaysPeriod(p)

	var total float64
	for _, r := range in {
		if categoryFilter(r) && periodFilter(r) {
			total += r.Amount
		}
	}

	return total, nil
}

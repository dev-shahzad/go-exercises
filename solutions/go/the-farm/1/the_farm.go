package thefarm

import (
	"errors"
	"fmt"
)

// Custom error for invalid cow count
type InvalidCowsError struct {
	NumberOfCows int
	Message      string
}

func (e InvalidCowsError) Error() string {
	return fmt.Sprintf("%d cows are invalid: %s", e.NumberOfCows, e.Message)
}

// DivideFood calculates fodder per cow

func DivideFood(fc FodderCalculator, numberOfCows int) (float64, error) {
	if numberOfCows <= 0 {
		return 0, errors.New("invalid number of cows")
	}

	totalFodder, err := fc.FodderAmount(numberOfCows)
	if err != nil {
		return 0, err
	}

	factor, err := fc.FatteningFactor()
	if err != nil {
		return 0, err
	}

	adjustedFodder := totalFodder * factor

	return adjustedFodder / float64(numberOfCows), nil
}

// ValidateInputAndDivideFood checks cow count and delegates to DivideFood
func ValidateInputAndDivideFood(fc FodderCalculator, numberOfCows int) (float64, error) {
	if numberOfCows <= 0 {
		return 0, errors.New("invalid number of cows")
	}
	return DivideFood(fc, numberOfCows)
}

// ValidateNumberOfCows returns a custom error for invalid cow counts
func ValidateNumberOfCows(numberOfCows int) error {
	if numberOfCows < 0 {
		return &InvalidCowsError{
			NumberOfCows: numberOfCows,
			Message:      "there are no negative cows",
		}
	} else if numberOfCows == 0 {
		return &InvalidCowsError{
			NumberOfCows: numberOfCows,
			Message:      "no cows don't need food",
		}
	}
	return nil
}


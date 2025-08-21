package census

type Resident struct {
	Name    string
	Age     int
	Address map[string]string
}

func NewResident(name string, age int, address map[string]string) *Resident {
	return &Resident{
        Name: name,
        Age: age,
        Address: address,
    }
}

func (r *Resident) HasRequiredInfo() bool {

    street, exists := r.Address["street"]
    return r.Name != "" && exists && street != ""
}

func (r *Resident) Delete() {
	r.Name = "" 
	r.Age = 0
	r.Address = nil
}

func Count(residents []*Resident) int {

    Count := 0 

    for _, resident := range residents {
        if resident.Name != "" && len(resident.Address) > 0 {
            Count ++
        }
    
    }

    return Count
     
}

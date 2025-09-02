package hamming
import "errors"

func Distance(a, b string) (int, error) {
	
    x := []byte(a)
    y := []byte(b)

    if len(x) > len(y) {
        return 0, errors.New("first strand is longer")
    }
    if len(y) > len(x) {
        return 0, errors.New("second strand is longer")
    }
    
    hammingDistance := 0 

    for i := range x {

        if x[i] != y[i] {
            hammingDistance++
        }
    }

    return hammingDistance, nil
    
}
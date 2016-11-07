package mygolibrary

import (
    "fmt"
)

var jc JavaCallback
type JavaCallback interface {
	CallFromGo(string)
}

func Hello(name string) string {
	return "Hello " + name + "! (from go)"
}

func HelloCallback(name string) {
    jc.CallFromGo("Bonjour " + name + "! (from go)")
}

func RegisterJavaCallback(c JavaCallback) {
	jc = c
    fmt.Println("Java callback registered", jc);
}



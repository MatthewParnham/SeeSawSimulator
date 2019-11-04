#!/bin/sh

echo "Compiling.."

javac Main.java

echo "Executing.."

java Main > output.txt

echo "Output to 'output.txt'"

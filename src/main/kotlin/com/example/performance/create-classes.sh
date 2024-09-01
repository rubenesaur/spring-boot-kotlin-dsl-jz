#!/bin/bash

for i in {1..10000}
do
	echo "package com.example.performance.filestoscan

class ScanClass$i {
}" > filestoscan/ScanClass${i}.kt
done

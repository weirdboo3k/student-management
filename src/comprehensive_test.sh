#!/bin/bash

echo "=== Test 1: Negative ID accepted ==="
echo -e "1\n-5\nNegative ID Student\n20\n50\n50\n50\n2\n0" | java StudentManagement 2>&1 | grep -A1 "学生一覧"

echo -e "\n=== Test 2: Data corruption in updateStudent - invalid age ==="
echo -e "1\n10\nOriginal\n20\n70\n70\n70\n3\n10\nModified\n200\n2\n0" | java StudentManagement 2>&1 | grep -A1 "学生一覧"

echo -e "\n=== Test 3: Data corruption in updateStudent - invalid score ==="
echo -e "1\n10\nOriginal\n20\n70\n70\n70\n3\n10\nModified\n25\n150\n2\n0" | java StudentManagement 2>&1 | grep -A1 "学生一覧"

echo -e "\n=== Test 4: Scanner buffer corruption after duplicate ID ==="
echo -e "1\n1\nFirst\n20\n50\n50\n50\n1\n1\nSecond\n20\n50\n50\n50\n2\n0" | java StudentManagement 2>&1 | tail -20


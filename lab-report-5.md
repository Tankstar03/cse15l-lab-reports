# Lab Report 5
Code for `grade.sh`
```
set -e

rm -rf student-submission
git clone $1 student-submission

if [ -f student-submission/ListExamples.java ]
then
    cp TestListExamples.java student-submission
    cp -r lib student-submission
    cp Server.java student-submission
    cp GradeServer.java student-submission
else
    echo "ListExamples.java not found at top file. Check your submission. "
    echo "You score is 0. "
    exit 1
fi

cd student-submission

set +e
javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java 2> test-err.txt
set -e

if [ -s test-err.txt ]
then
    grep -iw "" test-err.txt
    echo "compiling error! "
    echo "You score is 0. "
    exit 1
fi

SCORE=0

set +e
java -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples > test-out.txt
set -e

if [[ $(grep -c "^OK" test-out.txt) -eq 1 ]]
then
    echo $?
    SCORE=$(grep -Po "\d+ test" test-out.txt | grep -Po "\d+")
    grep -iw "" test-out.txt
    echo "Total test(s) ran: " $SCORE
    echo "Your final score: " $SCORE
else
    TESTS=$(grep -Po "Tests run: \d+" test-out.txt | grep -Po "\d+")
    DEDUCTIONS=$(grep -Po "Failures: \d+" test-out.txt | grep -Po "\d+")
    SCORE=$((TESTS-DEDUCTIONS))
    grep -iw "" test-out.txt
    echo "Total test(s) ran: " $TESTS
    echo "Your final score: " $SCORE
fi
```
### Example 1:

![image](Screenshots\GradeServer-1.png)

lines 5 and 6 removes the previous submission and clones the next submission respectively. The following if statement then checks to see if the ListExamples.java file is present in the correct repository, which in this case is present, thus the if statement will be true and executes the lines under `then`.

The script then will cd into student-submission and try to compile the file, with the standard error of the compile being stored into a file called test-err.txt. The compile in this case goes through without any problems, meaning test-err.txt will just be a blank file and the following if statement returning false.

The score is then initiallized to 0 and the standard-output of the file is then being stored into a file called test-out.txt. The last if statement checks whether or not all tests passed. In this case, that is true, so the score is equal to the number of tests ran. If the statement were false, the score would take into factor the number of tests failed, and calculate the final score to be the number of tests passed.

### Example 2:

![image](Screenshots\GradeServer-2.png)

### Example 3:

![image](Screenshots\GradeServer-3.png)

[Back to index](https://tankstar03.github.io/cse15l-lab-reports/)

[Back to github](https://github.com/Tankstar03/cse15l-lab-reports)
@echo off

color 0a

cls

cd C:\Users\Dominic\Documents\GitHub\CSE231-ClassProject

REM : Compile
javac -d bin -sourcepath source source\edu\oakland\production\Database\ArrayListTest.java

REM : Test class
java -cp bin;c:\junit3.8.2\junit.jar; junit.swingui.TestRunner edu.oakland.test.ClassProject.Database.ArrayListTest
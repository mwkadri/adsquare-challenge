# <img src="src/main/resources/adsquare-logo.png" width="48"> adSquare Challenge
An application that returns the second biggest number

- **Version 1.0.0**

---

## What This Is

- An application using Java able to iterate over integers 
  and returns 2nd biggest element on that structure.

---

## How To Use
- Build and Run Tests π  **mvn clean install**
- Run Tests Only π  **mvn test**
- Run App π  You can run the app by running the main method in AppRunner class
  - AppRunner π  located at **src/main/java/com/adsquare/example/runner/AppRunner.java**
- The input is being read from a txt file called "DemoFile.txt"
  - DemoFile.txt file π located at **src/main/resources/DemoFile.txt**

---

## Structure Explained
- **Java code is structured into three main packages**

  <br>

  - **(1) calculation** π  Follows BCE Archetype.
    
    - **(a) boundary** π  Any access to a functionality implemented in calculation package should be through the boundary layer.
      - NumChecker Interface π  Has One method.
        - findMaxTwoIntegersGateway π  Takes **FileParser parser** as an argument and returns **Result** Object.
      - NumCheckerImpl π  Implements NumChecker Interface.
        - getLargestTwoNumbersAggregateGateway π  Only purpose is to call **getLargestTwoNumbersAggregate()** method
          located in **NumCheckerCtrl** Class, because as mentioned we need to access method from the boundary layer.

    <br>
    
    - **(b) control** π  Result calculations are performed in this control package.
      - NumCheckerCtrl π  Has two private methods and one public method that can be accessed through boundary layer.
        - getLargestTwoNumbersAggregate π  Handles the following scenarios:
          - If chunk being processed is empty then it breaks, else it gets the largest two numbers in this processedChunk.
          - If currentChunkResult is empty then I set it with newChunkResult which has the highest two integers.
          - If currentChunkResult is not empty then I get the largest two number from current and next chunks.
        - getLargestNumberFromTwoChunks π  Private method called in getLargestTwoNumbersAggregate().
          - Takes two arguments of type **Result** two compare between them and gets largest two numbers.
          - If one of the two chunks being passed are null then we return the other.
          - Finally, we save both Result obj in a Collection that is then sent to getLargestTwoNumbers() to return a 
            single Result obj with the two biggest numbers out of both chunks
        - findMaxTwoIntegers π  Private method called in getLargestNumberFromTwoChunks(). 
          - Searches **Collection<Integer>** and sets the **Result** obj with the highest and
          second highest number. If the collection passed is Empty it will return null and if the collection
          has only one element then it will set the **Result's maxNum** attribute with that single number
    
    <br>
            
    - **(c) entity** π  Objects/Models used are placed in this package
      - Result π  Result Object with two attributes to represent biggest and second biggest number.
        - maxNum π  Is set with the biggest number.
        - secondMaxNum π  Is set with the second biggest number.
        - toList() π  makes sure that none of the maxNum, and the secondMaxNum attributes are null 
          before adding them to a **Collection<Integer>**
  
    <br>
  
  - **(2) reader** π  Has One File Parse Interface and Two Classes that implement it.
    - FileParse Interface π  Contains two methods.
        - loadFile π  Finds and loads **DemoFile.txt** from **src/main/resources/DemoFile.txt**.
        - getNextChunk π  Reads file chunk by chunk and returns **Collection<Integer>**.
    - FileParseImpl π  Implements FileParser interface.
      - loadFile π  Uses bufferReader and passes path of file in constructor to be sort of dynamic. 
      - getNextChunk π  Reads file chunk by chunk and returns **Collection<Integer>** 
        chunkSize is static for now and has a value of **1000**.
    - FileParserMock π  Implements FileParser interface and is used for testing purpose.
      - FileParserMock π  Constructor takes an dummyChunk of type**ArrayList<Collection<Integer>>**  .
      - loadFile π  Resets nextChunkPointer to Zero.
      - getNextChunk π  returns chunk that the nextChunkPointer is pointing to.  
  
    <br>
  
  - **(3) runner** π  Has the AppRunner Class that contains the main method to run the app. 
    - Main method code in AppRunner does three things:
      - Loads File from path.
      - Finds the Overall Largest Two Numbers.
      - Prints Second Highest Number.

---

## Technologies used
- Java 11
- Maven
- Junit
- BufferedReader

---

## Improvements
- Can change chunk size to be configurable by reading it from an application.properties file.
- Can change the file being read, and it's type to be configurable by reading it from an 
  application.properties file and passing it as an argument in the load file.
- Adding Integration Test for the boundary layer.


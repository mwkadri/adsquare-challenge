# <img src="src/main/resources/adsquare-logo.png" width="48"> adSquare Challenge
An application that returns the second biggest number

- **Version 1.0.0**

---

## What This Is

- An application using Java able to iterate over integers 
  and returns 2nd biggest element on that structure.

---

## Structure Explained
- **Java code is structured into three main packages**

  <br>

  - **(1) calculation** 🠊 Follows BCE Archetype.
    
    - **(a) boundary** 🠊 Any access to a functionality implemented in calculation package should be through the boundary layer.
      - NumChecker Interface 🠊 Has One method.
        - findMaxTwoIntegersGateway 🠊 Takes **FileParser parser** as an argument and returns **Result** Object.
      - NumCheckerImpl 🠊 Implements NumChecker Interface.
        - getLargestTwoNumbersAggregateGateway 🠊 Only purpose is to call **getLargestTwoNumbersAggregate()** method
          located in **NumCheckerCtrl** Class, because as mentioned we need to access method from the boundary layer.

    <br>
    
    - **(b) control** 🠊 Result calculations are performed in this control package.
      - NumCheckerCtrl 🠊 Has two private methods and one public method that can be accessed through boundary layer.
        - getLargestTwoNumbersAggregate 🠊 Handles the following scenarios:
          - If chunk being processed is empty then it breaks, else it gets the largest two numbers in this processedChunk.
          - If currentChunkResult is empty then I set it with newChunkResult which has the highest two integers.
          - If currentChunkResult is not empty then I get the largest two number from current and next chunks.
        - getLargestNumberFromTwoChunks 🠊 Private method called in getLargestTwoNumbersAggregate().
          - Takes two arguments of type **Result** two compare between them and gets largest two numbers.
          - If one of the two chunks being passed are null then we return the other.
          - Finally, we save both Result obj in a Collection that is then sent to getLargestTwoNumbers() to return a 
            single Result obj with the two biggest numbers out of both chunks
        - findMaxTwoIntegers 🠊 Private method called in getLargestNumberFromTwoChunks(). 
          - Searches **Collection<Integer>** and sets the **Result** obj with the highest and
          second highest number. If the collection passed is Empty it will return null and if the collection
          has only one element then it will set the **Result's maxNum** attribute with that single number
    
    <br>
            
    - **(c) entity** 🠊 Objects/Models used are placed in this package
      - Result 🠊 Result Object with two attributes to represent biggest and second biggest number.
        - maxNum 🠊 Is set with the biggest number.
        - secondMaxNum 🠊 Is set with the second biggest number.
        - toList() 🠊 makes sure that none of the maxNum, and the secondMaxNum attributes are null 
          before adding them to a **Collection<Integer>**
  
    <br>
  
  - **(2) reader** 🠊 Has One File Parse Interface and Two Classes that implement it.
    - FileParse Interface 🠊 Contains two methods.
        - loadFile 🠊 Finds and loads **DemoFile.txt** from **src/main/resources/DemoFile.txt**.
        - getNextChunk 🠊 Reads file chunk by chunk and returns **Collection<Integer>**.
    - FileParseImpl 🠊 Implements FileParser interface.
      - loadFile 🠊 Uses bufferReader and passes path of file in constructor to be sort of dynamic. 
      - getNextChunk 🠊 Reads file chunk by chunk and returns **Collection<Integer>** 
        chunkSize is static for now and has a value of **1000**.
    - FileParserMock 🠊 Implements FileParser interface and is used for testing purpose.
      - FileParserMock 🠊 Constructor takes an dummyChunk of type**ArrayList<Collection<Integer>>**  .
      - loadFile 🠊 Resets nextChunkPointer to Zero.
      - getNextChunk 🠊 returns chunk that the nextChunkPointer is pointing to.  
  
    <br>
  
  - **(3) runner** 🠊 Has the AppRunner Class that contains the main method to run the app. 
    - Main method code in AppRunner does three things:
      - Loads File from path.
      - Finds the Overall Largest Two Numbers.
      - Prints Second Highest Number.

---

## How To Use
- Build and Run Tests 🠊 **mvn clean install**
- Run Tests Only 🠊 **mvn test**
- Run App 🠊 You can run the app by running the main method in AppRunner class
<br>
    - located at **src/main/java/com/adsquare/example/runner/AppRunner.java**
- The input is being read from a txt file called "DemoFile.txt"
<br>
    - located at **src/main/resources/DemoFile.txt**
  
---

## Technologies used
- Java 11
- Maven
- Junit
- BufferedReader

---

## Improvements
- Can change chunk size to be configurable by reading it from an application.properties file.
- Adding Integration Test for the boundary layer


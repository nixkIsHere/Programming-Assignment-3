# Programming-Assignment-3

## Overview
This program is a solution to convert mathematical expressions from **Infix notation** to **Postfix notation**. The program reads infix expressions from an input file, checks their validity, and converts them to postfix if they are valid. The program is implemented in Java and consists of the following files:

- `InfixToPostfix.java`: Contains the main program logic, including expression validation, conversion from infix to postfix, and output display.
- `Stack.java`: Implements a stack data structure using a linked list for processing operators and operands.
- `Node.java`: Defines the `Node` class used by the `Stack` class to represent the individual elements in the stack.

## Author Information
- **Student ID:** 662115016
- **Email:** natthaphum_ch@cmu.ac.th
- **Name:** Natthaphum Chaikhan

## List of Files
1. `InfixToPostfix.java`
2. `Stack.java`
3. `Node.java`

## How to Compile the Program
To compile the program, run the following command in the terminal:
```bash
javac InfixToPostfix.java Stack.java Node.java
```
## How to Run the Program
To run the program, use the following command with an input file:
```bash
java InfixToPostfix input1.csv
```
### File Path Considerations:
- If the `.csv` file is located in a different directory, you need to provide the **full file path** when running the program. For example:
    - **Windows**: `C:\Users\YourUsername\Documents\input1.csv`
    - **Linux/macOS**: `/home/yourusername/documents/input1.csv`
    
    You can specify the full path like this:
    ```bash
    java InfixToPostfix "C:\Users\YourUsername\Documents\input1.csv"
    ```
    Or on Linux/macOS:
    ```bash
    java InfixToPostfix "/home/yourusername/documents/input1.csv"
    ```

- Alternatively, if the `.csv` file is in a different drive (for example, in the **D:** drive), you can change to the drive first (Windows only), then navigate to the directory where the file is located. For example:
    ```bash
    D:
    cd "D:\Documents"
    java InfixToPostfix input1.csv
    ```
### Input Format
- Each line of the input file should contain a mathematical expression in **infix notation**, which may include integers, operators (`+`, `-`, `*`, `/`, `^`), and parentheses.
- Expressions must be properly formatted, with matching parentheses and correct operator usage.
- The program will read the file line by line, validate each expression, and convert it to postfix notation if valid.

### Example of Valid Input:
```bash
(5 + 3) * (2 - (8 / 4))
((7 + 6) * (5 - 2)) / (4 + 1)
15 - ((3 * 8) / (2 + 2))
```
### Example of Not-Valid Input:
```bash
((15 - (3 * 8)) / (2 + 2)) < ((6 * 3) - 9)
(((7 + 5) * 2) / (9 - 3)) == ((8 + 4) / 3)
```
### Example Program Output:

#### Example of Valid Output:
Expression 1
```bash
Infix exp: (5 + 3) * (2 - (8 / 4))
Valid
Postfix exp: 5 3 + 8 4 / 2 - *
```
Expression 2
```bash
Infix exp: ((7 + 6) * (5 - 2)) / (4 + 1)
Valid
Postfix exp: 7 6 + 5 2 - * 4 1 + /
```
Expression 3
```bash
Infix exp: 15 - ((3 * 8) / (2 + 2))
Valid
Postfix exp: 15 3 8 * 2 2 + / -
```
#### Example of Not-Valid Output:
Expression 29
```bash
Infix exp: ((15 - (3 * 8)) / (2 + 2)) < ((6 * 3) - 9)
Not-Valid
```
Expression 30
```bash
Infix exp: (((7 + 5) * 2) / (9 - 3)) == ((8 + 4) / 3)
Not-Valid
```
If the input expression is not valid (for example, mismatched parentheses or invalid operator usage), the program will output `Not-Valid`.

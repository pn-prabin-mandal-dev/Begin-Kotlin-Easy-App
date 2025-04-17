package com.example.gds.beginkotlineasy.features.feature_tutorial.data_layer.model

object PrepopulateData {
    fun getTutorialCards(): List<TutorialScreenCardDataClass> {
        return listOf(
            // tutorialDetailsData[0]
            TutorialScreenCardDataClass(
                cardTitle = "Introduction",
                topicList = listOf(
                    // topicList[0]
                    "Kotlin Tutorial",
                    "Application of Kotlin",
                    "About Kotlin",
                    "History of Dart",
                    "Features of Kotlin",
                    "Drawbacks of Kotlin",
                    "IDEs",
                    "Installing Kotlin",
                    "Hello World Program",
                ),
                // tutorialDetailsData[0].contentMap[tutorialDetailsData[0].topicList[0,1,2..]]
                contentMap = mapOf(
                    "Kotlin Tutorial" to listOf(
                        "Learn Kotlin the easy way with our Detailed Programming Tutorial designed with Simplicity in Mind.",
                        "Whether you want to learn Java as a Hobby, For School/College, or want to build a Career in the field, this Tutorial is for you.",
                        "This tutorial covers everything from the Basics of Kotlin to Advanced Concepts like Data Structures.",
                        "We at OnePercent are constantly working to make the concepts of Programming Simple, Easy, Interesting, and Understandable to everyone."
                    ),
                    "Application of Kotlin" to listOf(
                        "Kotlin is widely used for Android development as it's the preferred language recommended by Google. Major apps like Twitter, Pinterest, and Airbnb use Kotlin for their Android applications due to its concise syntax and safety features.",
                        "Beyond mobile development, Kotlin is also used in server-side development with frameworks like Ktor and Spring, web development through Kotlin/JS, data science applications, and even multiplatform projects that share code between different platforms."
                    ),
                    "About Kotlin" to listOf(
                        "Kotlin is a statically typed, general-purpose programming language developed by JetBrains. First released in 2011, it combines object-oriented and functional programming features and is designed to interoperate fully with Java while being more concise and safer."
                    ),
                    "History of Dart" to listOf(
                        "Dart was introduced by Google in 2011. The name comes from Kotlin Island near St. Petersburg. Google announced first-class support for Kotlin on Android in 2017, which significantly boosted its popularity in the Android development community."
                    ),
                    "Features of Kotlin" to listOf(
                        "Kotlin offers numerous powerful features including null safety (eliminating NullPointerExceptions), extension functions (adding functionality to existing classes), smart casts, data classes (reducing boilerplate code), coroutines for asynchronous programming, and excellent Java interoperability."
                    ),
                    "Drawbacks of Kotlin" to listOf(
                            "While Kotlin has many advantages, there are some drawbacks to consider. These include slower compilation speed compared to Java in some cases, a steeper learning curve for beginners due to its rich feature set, and slightly larger APK sizes for Android applications."
                    ),
                    "IDEs" to listOf(
                        "Kotlin is well-supported in several IDEs including IntelliJ IDEA (which has the best Kotlin support as it's from the same company), Android Studio (with full Kotlin integration), Visual Studio Code (with Kotlin plugins), and Eclipse (with Kotlin plugin support)."
                    ),
                    "Installing Kotlin" to listOf(
                        "To get started with Kotlin, you can install it through the official JetBrains website by downloading IntelliJ IDEA which comes with Kotlin support built-in. Alternatively, you can install the Kotlin compiler separately and use it with your preferred editor or build system like Gradle or Maven."
                    ),
                    "Hello World Program" to listOf(
                        "To create your first Kotlin program, simply write: 'fun main() { println(\"Hello World!\") }'. This demonstrates Kotlin's concise syntax where the 'fun' keyword declares a function, 'main' is the entry point, and 'println' outputs text. No class declaration is needed for simple programs."
                    )
                )
            ),
            // index 1
            TutorialScreenCardDataClass(
                cardTitle = "Basic Concepts",
                topicList = listOf(
                    "Comments",
                    "DataTypes",
                    "Identifiers",
                    "Variables",
                    "Literals",
                    "Constants",
                    "Keywords",
                    "Operators",
                    "Input and Output Statement",
                    "Control Statements",
                ),
                contentMap = mapOf(
                    "Comments" to listOf( "Kotlin supports two types of comments: single-line and multi-line. Single-line comments start with // and continue to the end of the line, while multi-line comments are enclosed between /* and */. Comments are ignored by the compiler and are used to document code, explain complex logic, or temporarily disable code during debugging."),
                    "DataTypes" to listOf(
                        "Kotlin provides a rich set of built-in data types including:",
                        "- Numbers: Int (32-bit), Long (64-bit), Short (16-bit), Byte (8-bit)",
                        "- Floating-point: Double (64-bit), Float (32-bit)",
                        "- Boolean: true or false values",
                        "- Character: Single Unicode character (Char)",
                        "- String: Sequence of characters",
                        "- Arrays: Collections of similar data types",
                        "Kotlin's type system helps prevent common programming errors through type inference and strict type checking."
                    ),
                    "Identifiers" to listOf(
                        "Identifiers are names used for variables, functions, classes, and other program elements in Kotlin. Rules for identifiers include:",
                        "- Must begin with a letter or underscore",
                        "- Can contain letters, digits, and underscores",
                        "- Cannot be Kotlin keywords",
                        "- Are case-sensitive (myVar and myvar are different)",
                        "Good practice suggests using camelCase for variables/functions and PascalCase for class names, with meaningful descriptive names."
                    ),
                    "Variables" to listOf(
                        "Kotlin supports two types of variable declarations:",
                        "- val (immutable): Once assigned cannot be changed, similar to final in Java",
                        "- var (mutable): Can be reassigned after initialization",
                        "Kotlin uses type inference, so explicit type declaration is optional when the type can be inferred. For example: 'val name = \"Kotlin\"' infers String type, while 'val version: Double = 1.7' explicitly declares the type."
                    ),
                    "Literals" to listOf(
                        "Literals are constant values assigned to variables in Kotlin. Kotlin supports:",
                        "- Integer literals: 123, 0x0F (hex), 0b00001011 (binary)",
                        "- Floating-point literals: 123.5, 1.235e2 (scientific notation)",
                        "- Boolean literals: true, false",
                        "- Character literals: 'A', '\n' (escape sequences supported)",
                        "- String literals: \"Hello\", with support for escape characters and multi-line strings using triple quotes \"\"\"",
                        "- Null literal: null"
                    ),
                    "Constants" to listOf(
                        "Constants in Kotlin are declared using the 'const' modifier at compile-time. They must be:",
                        "- Declared at the top level or in an object declaration",
                        "- Initialized with a value of a primitive type or String",
                        "- Known at compile-time",
                        "Example: 'const val PI = 3.14159'. Constants are more efficient than regular vals as their values are inlined by the compiler where used."
                    ),
                    "Keywords" to listOf(
                        "Kotlin has several reserved keywords that have special meaning in the language:",
                        "- Declaration keywords: fun, val, var, class, object, interface",
                        "- Control flow: if, else, when, for, while, do, break, continue, return",
                        "- Modifiers: public, private, protected, internal, open, final, abstract",
                        "- Special: this, super, is, in, as, typealias, expect, actual",
                        "Some keywords are 'soft keywords' that only have special meaning in certain contexts and can be used as identifiers elsewhere."
                    ),
                    "Operators" to listOf(
                        "Kotlin supports a comprehensive set of operators including:",
                        "- Arithmetic: +, -, *, /, % (modulus)",
                        "- Comparison: ==, !=, <, >, <=, >=",
                        "- Logical: && (AND), || (OR), ! (NOT)",
                        "- Assignment: =, +=, -=, *=, /=, %=",
                        "- Bitwise: and, or, xor, inv, shl, shr, ushr",
                        "- Range: .. (rangeTo), in, !in",
                        "- Null safety: ?. (safe call), ?: (elvis operator), !! (not-null assertion)",
                        "Kotlin also allows operator overloading for custom types."
                    ),
                    "Input and Output Statement" to listOf(
                        "Kotlin provides simple ways to handle input and output:",
                        "- Output: print() and println() functions display text to standard output",
                        "- Input: readLine() reads user input as a String from standard input",
                        "- Formatted output can be achieved using string templates: println(\"Value: \$value\")",
                        "- For file I/O, Kotlin provides extensions in the java.io package and kotlin.io package with more convenient functions",
                        "Example: 'val name = readLine()' reads input, 'println(\"Hello \$name\")' prints output with variable interpolation."
                    ),
                    "Control Statements" to listOf(
                        "Kotlin offers several control flow structures:",
                        "- Conditional: if-else expressions (which can return a value), when expression (powerful replacement for switch)",
                        "- Looping: for (with ranges, arrays, or collections), while, do-while",
                        "- Jump: return, break, continue with optional labels for nested loops",
                        "- Exception handling: try-catch-finally blocks",
                        "Kotlin's control structures are expressions (can return values) rather than just statements, enabling more concise code. The 'when' expression is particularly powerful, supporting arbitrary conditions, type checks, and range checks."
                    )
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Data Types",
                topicList = listOf(
                    "Integer DataTypes",
                    "Float DataTypes",
                    "Boolean DataTypes",
                    "Character DataTypes",
                    "Array DataTypes",
                    "String DataTypes",
                ),
                contentMap = mapOf(
                    "Integer DataTypes" to listOf("Kotlin supports various integer types such as Int, Long, Short, and Byte."),
                    "Float DataTypes" to listOf("Float and Double are used for decimal values, with Double being more precise."),
                    "Boolean DataTypes" to listOf("Boolean represents true or false values."),
                    "Character DataTypes" to listOf("Char type holds a single character in Kotlin."),
                    "Array DataTypes" to listOf("Arrays hold multiple values of the same type."),
                    "String DataTypes" to listOf("String is a sequence of characters, defined within double quotes.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Operators",
                topicList = listOf(
                    "Arithmetic Operators",
                    "Increment and Decrement Operators",
                    "Assignment Operators",
                    "Relational Operators",
                    "Logical Operators",
                    "Bitwise Operators",
                ),
                contentMap = mapOf(
                    "Arithmetic Operators" to listOf("Includes +, -, *, /, % for mathematical operations."),
                    "Increment and Decrement Operators" to listOf("++ and -- operators for incrementing or decrementing values."),
                    "Assignment Operators" to listOf("Used to assign values, like '=', '+=', '-=' etc."),
                    "Relational Operators" to listOf("Used for comparing values, like '==', '!=', '>', '<', etc."),
                    "Logical Operators" to listOf("&&, ||, and ! for logical operations."),
                    "Bitwise Operators" to listOf("Used to perform operations on binary numbers.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Selections",
                topicList = listOf(
                    "Simple If",
                    "If Else",
                    "Else If Ladder",
                    "Nested If",
                    "When",
                ),
                contentMap = mapOf(
                    "Simple If" to listOf("Executes a block of code if a condition is true."),
                    "If Else" to listOf("Executes one block if true, and another if false."),
                    "Else If Ladder" to listOf("Chains multiple conditions together."),
                    "Nested If" to listOf("An If statement inside another If."),
                    "When" to listOf("Switch-case replacement in Kotlin, more powerful and flexible.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Iteration",
                topicList = listOf(
                    "While Loop",
                    "Do-While Loop",
                    "For In Loop",
                    "Nested Loop",
                ),
                contentMap = mapOf(
                    "While Loop" to listOf("Repeats code as long as a condition is true."),
                    "Do-While Loop" to listOf("Similar to While, but the condition is checked after the loop."),
                    "For In Loop" to listOf("Used to iterate over ranges, collections, or arrays."),
                    "Nested Loop" to listOf("A loop inside another loop.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Other Resources",
                topicList = listOf(
                    "break Keyword",
                    "continue Keyword",
                ),
                contentMap = mapOf(
                    "break Keyword" to listOf("Used to exit from a loop or switch statement."),
                    "continue Keyword" to listOf("Skips the current iteration of a loop and continues to the next iteration.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Functions",
                topicList = listOf(
                    "Functions",
                    "Passing Values to Functions",
                    "Returning Values From Functions",
                    "Recursive Functions",
                    "When",
                ),
                contentMap = mapOf(
                    "Functions" to listOf("Functions are blocks of code that perform specific tasks."),
                    "Passing Values to Functions" to listOf("Values can be passed to functions as parameters."),
                    "Returning Values From Functions" to listOf("A function can return a value using the 'return' keyword."),
                    "Recursive Functions" to listOf("A recursive function calls itself until a base condition is met."),
                    "When" to listOf("The 'when' expression is a replacement for switch-case in Kotlin, offering a more flexible way of branching.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Arrays",
                topicList = listOf(
                    "Arrays",
                    "Types of Arrays",
                    "1-D Array",
                    "2-D Array",
                ),
                contentMap = mapOf(
                    "Arrays" to listOf("Arrays are collections of elements of the same type."),
                    "Types of Arrays" to listOf("Kotlin supports mutable and immutable arrays."),
                    "1-D Array" to listOf("A one-dimensional array stores elements in a single list."),
                    "2-D Array" to listOf("A two-dimensional array is an array of arrays, forming a matrix-like structure.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Strings",
                topicList = listOf(
                    "Strings",
                    "String Methods",
                    "Multiline Strings",
                    "compareTo()",
                    "get()",
                    "plus()",
                    "subSequence()",
                    "contains()",
                    "count()",
                    "drop()",
                    "dropLast()",
                    "indexOf()",
                    "toLowerCase()",
                    "toUpperCase()",
                ),
                contentMap = mapOf(
                    "Strings" to listOf("Strings are sequences of characters enclosed in double quotes."),
                    "String Methods" to listOf("Kotlin provides various methods to manipulate strings, like 'length', 'trim', etc."),
                    "Multiline Strings" to listOf("Multiline strings are enclosed by triple quotes (\"\"\"...\"\"\")."),
                    "compareTo()" to listOf("Compares two strings and returns a negative, zero, or positive integer."),
                    "get()" to listOf("Used to retrieve a character at a given index from a string."),
                    "plus()" to listOf("Concatenates two strings."),
                    "subSequence()" to listOf("Extracts a portion of a string between given start and end indices."),
                    "contains()" to listOf("Checks if a string contains a specified sequence of characters."),
                    "count()" to listOf("Counts the number of characters in a string."),
                    "drop()" to listOf("Removes the first 'n' characters from a string."),
                    "dropLast()" to listOf("Removes the last 'n' characters from a string."),
                    "indexOf()" to listOf("Finds the index of the first occurrence of a character or substring."),
                    "toLowerCase()" to listOf("Converts all characters of the string to lowercase."),
                    "toUpperCase()" to listOf("Converts all characters of the string to uppercase.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Maths",
                topicList = listOf(
                    "Math Functions",
                    "abs()",
                    "max()",
                    "min()",
                    "round()",
                    "sqrt()",
                    "cbrt()",
                    "pow()",
                    "sin()",
                    "cos()",
                    "tan()",
                    "asin()", // arc sine
                    "acos()",
                    "atan()",
                    "sinh()",
                    "cosh()",
                    "tanh()", // hyperbolic tangent
                    "exp()",
                    "log()",
                    "log10()",
                ),
                contentMap = mapOf(
                    "Math Functions" to listOf("Kotlin provides a math library to perform complex mathematical operations."),
                    "abs()" to listOf("Returns the absolute value of a number."),
                    "max()" to listOf("Returns the larger of two numbers."),
                    "min()" to listOf("Returns the smaller of two numbers."),
                    "round()" to listOf("Rounds a floating-point number to the nearest integer."),
                    "sqrt()" to listOf("Returns the square root of a number."),
                    "cbrt()" to listOf("Returns the cube root of a number."),
                    "pow()" to listOf("Raises a number to a specified power."),
                    "sin()" to listOf("Returns the sine of an angle (in radians)."),
                    "cos()" to listOf("Returns the cosine of an angle (in radians)."),
                    "tan()" to listOf("Returns the tangent of an angle (in radians)."),
                    "asin()" to listOf("Returns the arc sine (inverse of sine)."),
                    "acos()" to listOf("Returns the arc cosine (inverse of cosine)."),
                    "atan()" to listOf("Returns the arc tangent (inverse of tangent)."),
                    "sinh()" to listOf("Returns the hyperbolic sine of a number."),
                    "cosh()" to listOf("Returns the hyperbolic cosine of a number."),
                    "tanh()" to listOf("Returns the hyperbolic tangent of a number."),
                    "exp()" to listOf("Returns e raised to the power of the specified number."),
                    "log()" to listOf("Returns the natural logarithm of a number."),
                    "log10()" to listOf("Returns the base-10 logarithm of a number.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "OOPs Concepts",
                topicList = listOf(
                    "OOPs Concepts",
                    "Objects and Classes",
                    "Constructor",
                    "Inheritance",
                    "Polymorphism",
                    "Abstract Class",
                    "Interface",
                ),
                contentMap = mapOf(
                    "OOPs Concepts" to listOf("Object-Oriented Programming (OOP) is a programming paradigm based on objects and classes."),
                    "Objects and Classes" to listOf("An object is an instance of a class. A class defines the structure and behavior of objects."),
                    "Constructor" to listOf("A constructor is a special function used to initialize objects."),
                    "Inheritance" to listOf("Inheritance allows a class to inherit properties and behaviors from another class."),
                    "Polymorphism" to listOf("Polymorphism allows methods to have the same name but different implementations."),
                    "Abstract Class" to listOf("An abstract class cannot be instantiated and may contain abstract methods that must be implemented in subclasses."),
                    "Interface" to listOf("An interface defines a contract that classes must implement.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Errors",
                topicList = listOf(
                    "Errors",
                    "Compile-Time Errors",
                    "Run-Time Errors",
                    "Logical Errors",
                ),
                contentMap = mapOf(
                    "Errors" to listOf("Errors occur when the code doesn't work as expected."),
                    "Compile-Time Errors" to listOf("These errors occur during the compilation of the program."),
                    "Run-Time Errors" to listOf("These errors occur during the execution of the program."),
                    "Logical Errors" to listOf("These errors occur when the program runs successfully but doesn't produce the correct output.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "Exception Handling",
                topicList = listOf(
                    "Exception Handling",
                    "Try-Catch Block",
                    "Finally Keyword",
                    "throw Keyword",
                ),
                contentMap = mapOf(
                    "Exception Handling" to listOf("Exception handling allows us to manage runtime errors gracefully."),
                    "Try-Catch Block" to listOf("Used to handle exceptions by wrapping risky code in a 'try' block and catching exceptions in a 'catch' block."),
                    "Finally Keyword" to listOf("The 'finally' block contains code that will always execute, regardless of whether an exception was thrown."),
                    "throw Keyword" to listOf("Used to explicitly throw an exception from a function or block of code.")
                )
            ),
            TutorialScreenCardDataClass(
                cardTitle = "File Handling",
                topicList = listOf(
                    "File Handling",
                    "Create a File",
                    "Write into a File",
                    "Read from a File",
                ),
                contentMap = mapOf(
                    "File Handling" to listOf("File handling in Kotlin is used to create, read, write, and modify files."),
                    "Create a File" to listOf("To create a file, you can use the 'File' class and call 'createNewFile()'."),
                    "Write into a File" to listOf("You can write to a file using 'writeText()' or 'appendText()'."),
                    "Read from a File" to listOf("Reading from a file can be done using 'readText()' or 'bufferedReader()'.")
                )
            )
        )
    }
}
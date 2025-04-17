package com.example.gds.beginkotlineasy.features.feature_interview_question.data_layer.db

import com.example.gds.beginkotlineasy.features.feature_interview_question.data_layer.data.InterviewQuestion


class InterviewQuestionRepository {
    fun getQuestions() : List<InterviewQuestion>{
        return listOf(
            InterviewQuestion(
                1,
                "What is the difference between the variable declaration with var and val?",
                "In Kotlin, 'var' is used to declare mutable (changeable) variables, meaning you can reassign them after initialization. On the other hand, 'val' is used to declare immutable (unchangeable) variables. Once a value is assigned to a 'val' variable, it cannot be reassigned."
            ),
            InterviewQuestion(
                2,
                "What is the difference between variable declaration with val and const?",
                "Both 'val' and 'const' in Kotlin are used to declare immutable variables. However, 'const' variables are compile-time constants, meaning their values must be known and assigned during compilation. In contrast, 'val' variables are runtime constants, meaning their values can be assigned at runtime."
            ),
            InterviewQuestion(
                3,
                "What is the difference between the safe calls (?.) and null check(!!)?",
                "The safe call operator '?.' is used to safely access properties or methods on nullable types without causing a NullPointerException. The '!!' operator forces a value to be non-null and throws an exception if the value is null."
            ),
            InterviewQuestion(
                4,
                "Do we have a ternary operator in Kotlin just like Java?",
                "No, Kotlin doesn't have a ternary operator. Instead, you can use a simple if-else expression to achieve the same result."
            ),
            InterviewQuestion(
                5,
                "What is Elvis operator in Kotlin?",
                "The Elvis operator '?:' is used to provide a default value when an expression is null. If the expression before the operator is null, the value after the operator is returned."
            ),
            InterviewQuestion(
                6,
                "What is a data class in Kotlin?",
                "A data class in Kotlin is a class that is specifically designed to hold data. It automatically generates useful methods like equals(), hashCode(), and toString() based on the properties defined in the class."
            ),
            InterviewQuestion(
                7,
                "Can we use primitive types such as int, double, float in Kotlin?",
                "No, Kotlin does not have primitive types. Instead, it uses their wrapper classes (e.g., Int, Double, Float) as objects, but Kotlin provides excellent interoperability with Java primitive types."
            ),
            InterviewQuestion(
                8,
                "What is String Interpolation in Kotlin?",
                "String interpolation in Kotlin allows you to embed variables or expressions inside strings using the '$' symbol. For example, 'val name = 'John'; println('Hello, \$name!')' will print 'Hello, John!'"
            ),
            InterviewQuestion(
                9,
                "What do you mean by destructing in Kotlin?",
                "Destructuring in Kotlin allows you to unpack values from data classes or other objects into multiple variables. For example, 'val (a, b) = pair' extracts the values of a Pair into variables 'a' and 'b'."
            ),
            InterviewQuestion(
                10,
                "Is there any difference between == operator and === operator?",
                "'==' checks for structural equality (i.e., if the content of the objects is the same), while '===' checks for referential equality (i.e., if both references point to the same object in memory)."
            ),
            InterviewQuestion(
                11,
                "What is the foreach in Kotlin?",
                "'forEach' is a higher-order function in Kotlin used to iterate over collections. It applies the provided operation to each element in the collection."
            ),
            InterviewQuestion(
                12,
                "What are the Companion objects in Kotlin?",
                "A companion object is a special object declared inside a class, which can hold members that are shared among all instances of the class, effectively functioning like static members in Java."
            ),
            InterviewQuestion(
                13,
                "What is the difference between FlatMap and Map in Kotlin?",
                "'Map' transforms each element of a collection into another value, creating a new collection. 'FlatMap', on the other hand, transforms each element into an iterable, and then flattens the resulting collection into a single collection."
            ),
            InterviewQuestion(
                14,
                "Can we use new keyword to instantiate a class object in Kotlin?",
                "No, Kotlin does not use the 'new' keyword for object instantiation. You simply call the constructor directly, like 'val obj = ClassName()'."
            ),
            InterviewQuestion(
                15,
                "What are visibility modifiers in Kotlin?",
                "Kotlin has four visibility modifiers: 'public' (default), 'internal' (accessible within the same module), 'protected' (accessible within the class and its subclasses), and 'private' (accessible only within the class or file)."
            ),
            InterviewQuestion(
                16,
                "How to create a Singleton class in Kotlin?",
                "To create a Singleton class in Kotlin, use the 'object' keyword. For example, 'object MySingleton { ... }' ensures that only one instance of the class exists."
            ),
            InterviewQuestion(
                17,
                "What are init blocks in Kotlin?",
                "The 'init' block is used to initialize an object when it is created. It is executed when the class constructor is called and is useful for initializing properties or performing setup operations."
            ),
            InterviewQuestion(
                18,
                "Is there any relationship between primary and secondary constructors in Kotlin?",
                "Yes, in Kotlin, a class can have both a primary constructor and one or more secondary constructors. The primary constructor is part of the class header, while secondary constructors are defined within the class body."
            ),
            InterviewQuestion(
                19,
                "What is the default type of an argument used in a constructor?",
                "The default type for constructor arguments in Kotlin is nullable. If no type is explicitly specified, it assumes a nullable type (e.g., 'String?')."
            ),
            InterviewQuestion(
                20,
                "What are Coroutines in Kotlin?",
                "Coroutines in Kotlin are used for managing asynchronous programming. They allow you to write non-blocking, concurrent code in a sequential manner, using 'suspend' functions and 'launch' or 'async' builders."
            ),
            InterviewQuestion(
                21,
                "What is the open keyword in Kotlin used for?",
                "The 'open' keyword in Kotlin is used to mark classes or functions as open for inheritance or overriding. By default, classes and functions in Kotlin are final and cannot be inherited or overridden."
            ),
            InterviewQuestion(
                22,
                "What are Lambda expressions in Kotlin?",
                "Lambda expressions in Kotlin are anonymous functions that can be passed as arguments or used inline. They are defined using the '->' syntax. For example, 'val sum = {a: Int, b: Int -> a + b}'."
            ),
            InterviewQuestion(
                23,
                "What are Higher-Order functions in Kotlin?",
                "Higher-order functions in Kotlin are functions that take other functions as parameters or return a function. They enable a functional programming style in Kotlin."
            ),
            InterviewQuestion(
                24,
                "What is infix function in Kotlin?",
                "An infix function in Kotlin is a function that can be called using infix notation, i.e., without parentheses. It is defined using the 'infix' keyword. For example, 'a add b' instead of 'a.add(b)'."
            ),
            InterviewQuestion(
                25,
                "What is a inlined function in Kotlin?",
                "An inline function in Kotlin is one where the compiler directly inserts the function body at the call site. This improves performance by avoiding the overhead of function calls."
            ),
            InterviewQuestion(
                26,
                "What is the operator Overloading in Kotlin?",
                "Operator overloading in Kotlin allows you to define custom behavior for standard operators (like +, -, *, etc.) for your own types by overriding certain operator functions."
            ),
            InterviewQuestion(
                27,
                "What is basic difference between fold and reduce in Kotlin?",
                "'fold' and 'reduce' are both used to aggregate the elements of a collection, but 'fold' allows you to specify an initial accumulator value, while 'reduce' starts the aggregation with the first element."
            ),
            InterviewQuestion(
                28,
                "What does 'Null Safety' mean in Kotlin?",
                "Null safety in Kotlin means that the language enforces checks to avoid null pointer exceptions. Nullable types are explicitly defined with a '?' (e.g., String?), and the compiler ensures proper null handling."
            ),
            InterviewQuestion(
                29,
                "Why is Kotlin interoperable with Java?",
                "Kotlin is fully interoperable with Java because it runs on the Java Virtual Machine (JVM). It can directly call Java code, and Java can call Kotlin code without issues due to the similarity in bytecode."
            ),
            InterviewQuestion(
                30,
                "How many constructors are available in Kotlin?",
                "Kotlin supports two types of constructors: primary constructors, which are part of the class header, and secondary constructors, which are defined inside the class body."
            ),
            InterviewQuestion(
                31,
                "Can you tell me, What kinds of programming types does Kotlin support?",
                "Kotlin supports several programming paradigms, including object-oriented programming, functional programming, and procedural programming."
            ),
            InterviewQuestion(
                32,
                "Can we migrate code from Java to Kotlin?",
                "Yes, Kotlin is fully interoperable with Java, allowing for a smooth migration of code. You can convert Java files to Kotlin with a tool provided in IntelliJ IDEA or Android Studio."
            ),
            InterviewQuestion(
                33,
                "What is the default behaviour of Kotlin classes?",
                "Kotlin classes are final by default, meaning they cannot be inherited unless marked with the 'open' keyword. Additionally, classes have an optional primary constructor and support both properties and methods."
            ),
            InterviewQuestion(
                34,
                "What is Ranges operator in Kotlin?",
                "The range operator '..' in Kotlin is used to create ranges, which are sequences of values. For example, '1..5' represents a range from 1 to 5."
            ),
            InterviewQuestion(
                35,
                "What is a Sealed class in Kotlin?",
                "A sealed class in Kotlin restricts class inheritance to a limited set of types. All subclasses must be declared within the sealed class itself, providing a closed hierarchy."
            ),
            InterviewQuestion(
                36,
                "How do you handle multiple threads in Kotlin?",
                "Kotlin handles multi-threading through Coroutines. Coroutines allow writing concurrent code in a sequential manner with minimal performance overhead using tools like 'launch', 'async', and 'suspend'."
            ),
            InterviewQuestion(
                37,
                "What is the difference between lateinit and lazy in Kotlin?",
                "'lateinit' is used for initializing non-null properties late, while 'lazy' is used to initialize a property once it's accessed. 'lazy' is typically used with immutable properties."
            ),
            InterviewQuestion(
                38,
                "What are extension functions in Kotlin?",
                "Extension functions allow you to add new functionality to existing classes without modifying their code. They are defined outside the class but are called as if they were part of the class."
            ),
            InterviewQuestion(
                39,
                "What is delegation in Kotlin?",
                "Delegation in Kotlin allows an object to hand over the responsibility of implementing some of its functionality to another object. This is often used in classes with the 'by' keyword."
            ),
            InterviewQuestion(
                40,
                "What is the difference between '==' and '===' in Kotlin?",
                "'==' checks for structural equality, meaning it compares the values of two objects. '===' checks for referential equality, meaning it compares whether two references point to the same object."
            ),
            InterviewQuestion(
                41,
                "How do you define a constant in Kotlin?",
                "Constants in Kotlin are defined using the 'const' keyword, which ensures that the value is known at compile time and cannot be changed at runtime."
            ),
            InterviewQuestion(
                42,
                "What is the purpose of the 'typealias' in Kotlin?",
                "The 'typealias' keyword in Kotlin allows you to create an alias for an existing type, making the code more readable or simplifying complex types."
            ),
            InterviewQuestion(
                43,
                "What is the purpose of the 'when' expression in Kotlin?",
                "'when' is a versatile expression in Kotlin that works as a switch statement, but is more powerful, allowing for complex conditions, multiple branches, and even ranges."
            ),
            InterviewQuestion(
                44,
                "What is a companion object in Kotlin?",
                "A companion object is a singleton object that is associated with a class. It can access private members of the class and is used to define class-level methods or properties."
            ),
            InterviewQuestion(
                45,
                "How do you create a custom exception in Kotlin?",
                "To create a custom exception in Kotlin, you can extend the Exception class or any other appropriate subclass, like so: 'class MyException(message: String): Exception(message)'."
            ),
            InterviewQuestion(
                46,
                "What is a suspend function in Kotlin?",
                "A suspend function in Kotlin is a function that can be paused and resumed at a later time, typically used with Coroutines to perform non-blocking operations."
            )
        )

    }
}
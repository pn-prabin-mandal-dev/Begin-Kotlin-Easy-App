package com.example.gds.beginkotlineasy.features.feature_quiz.data_layer.data

object PrepopulateData {
    fun getQuestions(): List<Question> {
        return listOf(
            // Easy Questions (30)
            Question(
                question = "Which keyword is used to declare a variable in Kotlin?",
                optionA = "const",
                optionB = "val",
                optionC = "var",
                optionD = "let",
                correctAnswer = "var",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the default visibility modifier in Kotlin?",
                optionA = "protected",
                optionB = "private",
                optionC = "public",
                optionD = "internal",
                correctAnswer = "public",
                difficulty = "Easy"
            ),
            Question(
                question = "Which function is used to print in Kotlin?",
                optionA = "write()",
                optionB = "echo()",
                optionC = "log()",
                optionD = "write()",
                correctAnswer = "print()",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the entry point of a Kotlin program?",
                optionA = "init()",
                optionB = "main()",
                optionC = "start()",
                optionD = "run()",
                correctAnswer = "main()",
                difficulty = "Easy"
            ),
            Question(
                question = "Which keyword is used to define a constant in Kotlin?",
                optionA = "var",
                optionB = "val",
                optionC = "const",
                optionD = "let",
                correctAnswer = "val",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the superclass of all classes in Kotlin?",
                optionA = "Object",
                optionB = "Any",
                optionC = "Base",
                optionD = "Super",
                correctAnswer = "Any",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is used to handle null references in Kotlin?",
                optionA = "if-else",
                optionB = "try-catch",
                optionC = "Elvis operator",
                optionD = "when",
                correctAnswer = "Elvis operator",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".length)'?",
                optionA = "5",
                optionB = "6",
                optionC = "7",
                optionD = "8",
                correctAnswer = "6",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for type checking?",
                optionA = "is",
                optionB = "as",
                optionC = "in",
                optionD = "of",
                correctAnswer = "is",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the default return type of a function in Kotlin?",
                optionA = "void",
                optionB = "Unit",
                optionC = "Any",
                optionD = "null",
                correctAnswer = "Unit",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is used to define a data class in Kotlin?",
                optionA = "data",
                optionB = "class",
                optionC = "data class",
                optionD = "struct",
                correctAnswer = "data class",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(10 / 3)' in Kotlin?",
                optionA = "3",
                optionB = "3.333",
                optionC = "3.0",
                optionD = "4",
                correctAnswer = "3",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for defining a lambda function?",
                optionA = "lambda",
                optionB = "fun",
                optionC = "->",
                optionD = "=>",
                correctAnswer = "->",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).size)'?",
                optionA = "1",
                optionB = "2",
                optionC = "3",
                optionD = "4",
                correctAnswer = "3",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is used to define a primary constructor in Kotlin?",
                optionA = "constructor",
                optionB = "init",
                optionC = "class",
                optionD = "fun",
                correctAnswer = "class",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(10 % 3)'?",
                optionA = "1",
                optionB = "2",
                optionC = "3",
                optionD = "0",
                correctAnswer = "1",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for defining a sealed class?",
                optionA = "sealed",
                optionB = "abstract",
                optionC = "final",
                optionD = "static",
                correctAnswer = "sealed",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\"[1])'?",
                optionA = "K",
                optionB = "o",
                optionC = "t",
                optionD = "l",
                correctAnswer = "o",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is used to define an extension function in Kotlin?",
                optionA = "fun",
                optionB = "extend",
                optionC = "extension",
                optionD = "function",
                correctAnswer = "fun",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(1..5 step 2)'?",
                optionA = "[1, 3, 5]",
                optionB = "[1, 2, 3, 4, 5]",
                optionC = "[2, 4]",
                optionD = "[1, 3]",
                correctAnswer = "[1, 3, 5]",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for defining a coroutine?",
                optionA = "coroutine",
                optionB = "async",
                optionC = "launch",
                optionD = "run",
                correctAnswer = "launch",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(\"Hello\".plus(\" World\"))'?",
                optionA = "Hello World",
                optionB = "HelloWorld",
                optionC = "Hello+World",
                optionD = "Error",
                correctAnswer = "Hello World",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin collection type?",
                optionA = "Array",
                optionB = "List",
                optionC = "Map",
                optionD = "All of the above",
                correctAnswer = "All of the above",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(2 + 2 * 2)' in Kotlin?",
                optionA = "4",
                optionB = "8",
                optionC = "6",
                optionD = "10",
                correctAnswer = "6",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for defining a function?",
                optionA = "func",
                optionB = "fun",
                optionC = "def",
                optionD = "function",
                correctAnswer = "fun",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the correct way to declare a nullable variable in Kotlin?",
                optionA = "var name: String?",
                optionB = "var name: String",
                optionC = "var name: String!",
                optionD = "var name: String*",
                correctAnswer = "var name: String?",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is used to iterate over a range in Kotlin?",
                optionA = "for",
                optionB = "while",
                optionC = "do-while",
                optionD = "repeat",
                correctAnswer = "for",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the correct way to create a singleton in Kotlin?",
                optionA = "class",
                optionB = "object",
                optionC = "singleton",
                optionD = "static",
                correctAnswer = "object",
                difficulty = "Easy"
            ),
            Question(
                question = "Which of the following is a Kotlin keyword for null safety?",
                optionA = "!!",
                optionB = "??",
                optionC = "?:",
                optionD = "::",
                correctAnswer = "!!",
                difficulty = "Easy"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".uppercase())'?",
                optionA = "KOTLIN",
                optionB = "kotlin",
                optionC = "Kotlin",
                optionD = "Error",
                correctAnswer = "KOTLIN",
                difficulty = "Easy"
            ),

            // Medium Questions (30)
            Question(
                question = "What is the purpose of the 'lateinit' keyword in Kotlin?",
                optionA = "To declare a nullable variable",
                optionB = "To initialize a variable later",
                optionC = "To declare a constant",
                optionD = "To define a lazy property",
                correctAnswer = "To initialize a variable later",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the difference between 'val' and 'var' in Kotlin?",
                optionA = "'val' is mutable, 'var' is immutable",
                optionB = "'val' is immutable, 'var' is mutable",
                optionC = "Both are immutable",
                optionD = "Both are mutable",
                correctAnswer = "'val' is immutable, 'var' is mutable",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).map { it * 2 })'?",
                optionA = "[1, 2, 3]",
                optionB = "[2, 4, 6]",
                optionC = "[1, 4, 9]",
                optionD = "[3, 6, 9]",
                correctAnswer = "[2, 4, 6]",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'let' function in Kotlin?",
                optionA = "To execute a block of code on a non-null object",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To execute a block of code on a non-null object",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".reversed())'?",
                optionA = "Kotlin",
                optionB = "niltoK",
                optionC = "KOTLIN",
                optionD = "Error",
                correctAnswer = "niltoK",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'also' function in Kotlin?",
                optionA = "To perform an action on an object and return the object",
                optionB = "To perform an action of the result",
                optionC = "To define a lambda function",
                optionD = "To handle exceptions",
                correctAnswer = "To perform an action on an object and return the object",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(sequenceOf(1, 2, 3).filter { it > 1 }.toList())'?",
                optionA = "[1, 2, 3]",
                optionB = "[2, 3]",
                optionC = "[1]",
                optionD = "[]",
                correctAnswer = "[2, 3]",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'run' function in Kotlin?",
                optionA = "To execute a block of code and return the result",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To execute a block of code and return the result",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".take(3))'?",
                optionA = "Kot",
                optionB = "Kotlin",
                optionC = "Kotli",
                optionD = "K",
                correctAnswer = "Kot",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'apply' function in Kotlin?",
                optionA = "To initialize an object and return it",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To initialize an object and return it",
                difficulty = "Medium"
            ),
            // 10
            Question(
                question = "What is the purpose of the 'takeIf' function in Kotlin?",
                optionA = "To execute a block of code if a condition is true",
                optionB = "To return the object if it satisfies a condition",
                optionC = "To define a lambda function",
                optionD = "To handle exceptions",
                correctAnswer = "To return the object if it satisfies a condition",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).any { it > 2 })'?",
                optionA = "true",
                optionB = "false",
                optionC = "2",
                optionD = "3",
                correctAnswer = "true",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'takeUnless' function in Kotlin?",
                optionA = "To execute a block of code if a condition is false",
                optionB = "To return the object if it does not satisfy a condition",
                optionC = "To define a lambda function",
                optionD = "To handle exceptions",
                correctAnswer = "To return the object if it does not satisfy a condition",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).all { it > 0 })'?",
                optionA = "true",
                optionB = "false",
                optionC = "1",
                optionD = "0",
                correctAnswer = "true",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'repeat' function in Kotlin?",
                optionA = "To repeat a block of code a specified number of times",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To repeat a block of code a specified number of times",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).none { it > 3 })'?",
                optionA = "true",
                optionB = "false",
                optionC = "3",
                optionD = "0",
                correctAnswer = "true",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'use' function in Kotlin?",
                optionA = "To automatically close a resource after use",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To automatically close a resource after use",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).sum())'?",
                optionA = "6",
                optionB = "3",
                optionC = "5",
                optionD = "1",
                correctAnswer = "6",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'require' function in Kotlin?",
                optionA = "To validate function arguments",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To validate function arguments",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).average())'?",
                optionA = "2.0",
                optionB = "3.0",
                optionC = "1.0",
                optionD = "0.0",
                correctAnswer = "2.0",
                difficulty = "Medium"
            ),
            // 20
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).filter { it % 2 == 0 })'?",
                optionA = "[1, 2, 3]",
                optionB = "[2]",
                optionC = "[1, 3]",
                optionD = "[]",
                correctAnswer = "[2]",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'with' function in Kotlin?",
                optionA = "To call multiple methods on an object",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To call multiple methods on an object",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".drop(2))'?",
                optionA = "Kotlin",
                optionB = "tlin",
                optionC = "Kot",
                optionD = "lin",
                correctAnswer = "tlin",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'lazy' keyword in Kotlin?",
                optionA = "To initialize a property lazily",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To initialize a property lazily",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).reduce { acc, i -> acc + i })'?",
                optionA = "6",
                optionB = "3",
                optionC = "5",
                optionD = "1",
                correctAnswer = "6",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'inline' keyword in Kotlin?",
                optionA = "To reduce overhead of higher-order functions",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To reduce overhead of higher-order functions",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(\"Kotlin\".substring(1, 4))'?",
                optionA = "Kot",
                optionB = "otl",
                optionC = "tli",
                optionD = "lin",
                correctAnswer = "otl",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'tailrec' keyword in Kotlin?",
                optionA = "To optimize tail-recursive functions",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To optimize tail-recursive functions",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).fold(0) { acc, i -> acc + i })'?",
                optionA = "6",
                optionB = "3",
                optionC = "5",
                optionD = "1",
                correctAnswer = "6",
                difficulty = "Medium"
            ),
            Question(
                question = "What is the purpose of the 'crossinline' keyword in Kotlin?",
                optionA = "To prevent non-local returns in lambdas",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To prevent non-local returns in lambdas",
                difficulty = "Medium"
            ),

            // Hard Questions (30)
            Question(
                question = "What is the purpose of the 'reified' keyword in Kotlin?",
                optionA = "To access type information at runtime",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To access type information at runtime",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).flatMap { listOf(it, it * 2) })'?",
                optionA = "[1, 2, 2, 4, 3, 6]",
                optionB = "[1, 2, 3]",
                optionC = "[2, 4, 6]",
                optionD = "[1, 4, 9]",
                correctAnswer = "[1, 2, 2, 4, 3, 6]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'noinline' keyword in Kotlin?",
                optionA = "To prevent inlining of a specific lambda",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To prevent inlining of a specific lambda",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).groupBy { it % 2 })'?",
                optionA = "{1=[1, 3], 0=[2]}",
                optionB = "{0=[1, 3], 1=[2]}",
                optionC = "{1=[1, 2], 0=[3]}",
                optionD = "{0=[1, 2], 1=[3]}",
                correctAnswer = "{1=[1, 3], 0=[2]}",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'suspend' keyword in Kotlin?",
                optionA = "To define a coroutine function",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To define a coroutine function",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).windowed(2))'?",
                optionA = "[[1, 2], [2, 3]]",
                optionB = "[[1, 2, 3]]",
                optionC = "[[1], [2], [3]]",
                optionD = "[[1, 3]]",
                correctAnswer = "[[1, 2], [2, 3]]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'operator' keyword in Kotlin?",
                optionA = "To overload operators",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To overload operators",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).zip(listOf(4, 5, 6)))'?",
                optionA = "[(1, 4), (2, 5), (3, 6)]",
                optionB = "[1, 2, 3, 4, 5, 6]",
                optionC = "[1, 4, 2, 5, 3, 6]",
                optionD = "[]",
                correctAnswer = "[(1, 4), (2, 5), (3, 6)]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'infix' keyword in Kotlin?",
                optionA = "To define infix functions",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To define infix functions",
                difficulty = "Hard"
            ),
            // 10
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).partition { it % 2 == 0 })'?",
                optionA = "([2], [1, 3])",
                optionB = "([1, 3], [2])",
                optionC = "([1, 2], [3])",
                optionD = "([3], [1, 2])",
                correctAnswer = "([2], [1, 3])",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'inline' keyword in Kotlin?",
                optionA = "To reduce overhead of higher-order functions",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To reduce overhead of higher-order functions",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).mapNotNull { if (it % 2 == 0) it else null })'?",
                optionA = "[1, 2, 3]",
                optionB = "[2]",
                optionC = "[1, 3]",
                optionD = "[]",
                correctAnswer = "[2]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'crossinline' keyword in Kotlin?",
                optionA = "To prevent non-local returns in lambdas",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To prevent non-local returns in lambdas",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).distinct())'?",
                optionA = "[1, 2, 3]",
                optionB = "[1, 2]",
                optionC = "[2, 3]",
                optionD = "[1, 3]",
                correctAnswer = "[1, 2, 3]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'tailrec' keyword in Kotlin?",
                optionA = "To optimize tail-recursive functions",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To optimize tail-recursive functions",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).chunked(2))'?",
                optionA = "[[1, 2], [3]]",
                optionB = "[[1], [2], [3]]",
                optionC = "[[1, 2, 3]]",
                optionD = "[[1, 2]]",
                correctAnswer = "[[1, 2], [3]]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'lazy' keyword in Kotlin?",
                optionA = "To initialize a property lazily",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To initialize a property lazily",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).associateWith { it * 2 })'?",
                optionA = "{1=2, 2=4, 3=6}",
                optionB = "{1=1, 2=2, 3=3}",
                optionC = "{2=1, 4=2, 6=3}",
                optionD = "{1=1, 2=4, 3=9}",
                correctAnswer = "{1=2, 2=4, 3=6}",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'sealed' keyword in Kotlin?",
                optionA = "To restrict class hierarchies",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To restrict class hierarchies",
                difficulty = "Hard"
            ),
            // 20
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).runningReduce { acc, i -> acc + i })'?",
                optionA = "[1, 3, 6]",
                optionB = "[1, 2, 3]",
                optionC = "[6]",
                optionD = "[3, 6]",
                correctAnswer = "[1, 3, 6]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'typealias' keyword in Kotlin?",
                optionA = "To create an alias for a type",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To create an alias for a type",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).zipWithNext())'?",
                optionA = "[(1, 2), (2, 3)]",
                optionB = "[(1, 2, 3)]",
                optionC = "[(1, 2)]",
                optionD = "[(2, 3)]",
                correctAnswer = "[(1, 2), (2, 3)]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'expect' keyword in Kotlin?",
                optionA = "To declare platform-specific APIs",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To declare platform-specific APIs",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).scan(0) { acc, i -> acc + i })'?",
                optionA = "[0, 1, 3, 6]",
                optionB = "[1, 3, 6]",
                optionC = "[0, 1, 2, 3]",
                optionD = "[1, 2, 3]",
                correctAnswer = "[0, 1, 3, 6]",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'actual' keyword in Kotlin?",
                optionA = "To implement platform-specific APIs",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To implement platform-specific APIs",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).reduceIndexed { index, acc, i -> acc + i * index })'?",
                optionA = "6",
                optionB = "8",
                optionC = "10",
                optionD = "12",
                correctAnswer = "8",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'value' keyword in Kotlin?",
                optionA = "To define an immutable property",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To define an immutable property",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).foldIndexed(0) { index, acc, i -> acc + i * index })'?",
                optionA = "6",
                optionB = "8",
                optionC = "10",
                optionD = "12",
                correctAnswer = "8",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the purpose of the 'const' keyword in Kotlin?",
                optionA = "To declare compile-time constants",
                optionB = "To define a lambda function",
                optionC = "To create a new object",
                optionD = "To handle exceptions",
                correctAnswer = "To declare compile-time constants",
                difficulty = "Hard"
            ),
            Question(
                question = "What is the output of 'println(listOf(1, 2, 3).mapIndexed { index, i -> i * index })'?",
                optionA = "[0, 2, 6]",
                optionB = "[1, 2, 3]",
                optionC = "[0, 1, 2]",
                optionD = "[1, 4, 9]",
                correctAnswer = "[0, 2, 6]",
                difficulty = "Hard"
            )

        )
    }
}
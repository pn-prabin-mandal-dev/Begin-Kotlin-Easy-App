package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model

// Object file for Program Data
// Object file for Program Data
object ProgramData {
    val topics = listOf(
        // Introduction
        ContentEntity(
            name = "Introduction",
            title = "Hello World Program",
            content = """
                //  Every Kotlin program starts from the main(){}
                // Main Method
                fun main(){
                    // Prints a Message saying "Hello World"
                    println("Hello World")
                }
            """.trimIndent(),
            type = "Program"
        ),

        // Basic Concept
        ContentEntity(
            name = "Basic Concept",
            title = "Comments",
            content = """
                fun main() {
                    
                  // This is a Single Line Comment

                  /* This is a
                  Multi Line Comment*/
              
                }
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Basic Concept",
            title = "Constants",
            content = """
                fun main() {

                   // Declaring and Initializing Constant
                   val con1 = 5
                   val con2 = 12

                   println("First Constant = " + con1)
                   println("Second Constant = " + con2)

                }
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Basic Concept",
            title = "Identifiers",
            content = """
                fun main(){

                    // Declaring and Initializing Constant
                    val con1 = 5
                    val con2 = 12

                    // Initializing Variables
                    var var1 = 5
                    var var2 = 12

                    // Changing Variable Values
                    var1 = 10
                    var2 = 20

                    println("First Constant = " + con1)
                    println("Second Constant = " + con2)
                    println("First Variable = " + var1)
                    println("Second Variable = " + var2)

                }
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Basic Concept",
            title = "Input and Output State",
            content ="""
                fun main() {

                   var x = 12;
                   println("Hello World")   // Prints Hello World
                   println("Value of X is " + x)   // Prints The Value of X
                   
                   println("Enter a value")
                   var y = readLine()   // Accepts a value from the user and stores it in the Variable y
                   
                   println("Value of Y is " + y);
                }
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Basic Concept",
            title = "Variables",
            content = """
                fun main() {

                   // Declaring and Initializing Variable
                   var var1 = 5
                   var var2 = 12

                   //  Changing Variable Value
                   var1 = 10
                   var2 = 20
                    
                   // Print Values
                   println("First Variable : " + var1)
                   println("Second Variable : " + var2)

                }
            """.trimIndent(),
            type = "Program"
        ),

        // DataTypes
        ContentEntity(
            name = "DataTypes",
            title = "Array DataType",
            content = """
                fun main() {

   var num = intArrayOf(1, 5, 7, 2, 3, 8, 4, 9, 6, 0)
   
   println("1st Number : " + num[0]);
   println("2nd Number : " + num[1]);
   println("3rd Number : " + num[2]);
   println("4th Number : " + num[3]);
   println("5th Number : " + num[4]);
   println("6th Number : " + num[5]);
   println("7th Number : " + num[6]);
   println("8th Number : " + num[7]);
   println("9th Number : " + num[8]);
   println("10th Number : " + num[9]);

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Boolean DataType",
            content = """
                fun main() {

   var X1 = true
   var X2 = false

   println("Value of X1 = "+ X1)
   println("Value of X1 = " + X2)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Character DataType",
            content = """
                fun main() {

   var X1 = 'A';
   var X2 = 'a';

   println("Value of X1 = "+ X1);
   println("Value of X2 = " + X2);

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Float DataType",
            content = """
                fun main() {

   var X1 = 1.0
   var X2 = 2.5

   println("Value of X1 = "+ X1)
   println("Value of X1 = " + X2)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Integer DataType",
            content = """
                fun main() {

   var X1 = 10
   var X2 = 1000

   println("Value of X1 = "+ X1)
   println("Value of X1 = " + X2)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "String DataType",
            content = """
                fun main() {

   var X = "Hello World"

   println(X)

}
            """.trimIndent(),
            type = "Program"
        ),


        // Operators
        ContentEntity(
            name = "Operators",
            title = "Arithmetic Operator",
            content = """
                fun main() {

   var X = 25
   var Y = 10

   var sum = X + Y
   var difference = X - Y
   var product = X * Y
   var quotient = X / Y
   var remainder = X % Y

   println("Sum of X and Y : "+ sum)
   println("Difference of X and Y : "+ difference)
   println("Product of X and Y : "+ product)
   println("Quotient of X and Y : "+ quotient)
   println("Remainder of X and Y : "+ remainder)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Operators",
            title = "Assignment Operator",
            content = """
                fun main() {

  var X1 = 5;
  println("Value of X1 : "+ X1);
  X1 += 5;
  println("Value of X1 : "+ X1);

  var X2 = 5;
  println("Value of X2 : "+ X2);
  X2 -= 5;
  println("Value of X2 : "+ X2);

  var X3 = 5;
  println("Value of X3 : "+ X3);
  X3 *= 5;
  println("Value of X3 : "+ X3);

  var X4 = 5;
  println("Value of X4 : "+ X4);
  X4 /= 5;
  println("Value of X4 : "+ X4);

  var X5 = 5;
  println("Value of X5 : "+ X5);
  X5 %= 5;
  println("Value of X5 : " + X5);

}

            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Operators",
            title = "Bitwise Operator",
            content = """
                fun main() {

    var X = 25 // 0001 1001
    var Y = 75 // 0100 1011
    
    println("Bitwise AND : "+ (X and Y))
    println("Bitwise OR : "+ (X or Y))
    println("Bitwise XOR : "+ (X xor Y))
    println("Bitwise NOT : "+ (X.inv()))
    println("Bitwise LEFT SSHIFT : "+ (X shl 1))
    println("Bitwise RIGHT SHIFT : "+ ( X shr1))

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Operators",
            title = "Increment and Decrement Operator",
            content = """
                fun main() {

   var X = 5
   println("Initial Value of X : "+ X)
   X++
   println("Value of X after Increment : "+ X)
   X--
   println("Value of X after Decrement : " + X)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Operators",
            title = "Logical Operator",
            content = """
                fun main() {

  var X = 5;
  var Y = 10;

  println("First Condition : "+ (X == Y && X != Y));
  println("Second Condition : "+ (X == Y || X != Y));
  println("Third Condition : "+ !(X == Y));

}
            """.trimIndent(),
            type = "Program"
        ),

        ContentEntity(
            name = "Operators",
            title = "Relational Operator",
            content = """
                 fun main() {

   var X = 5;
   var Y = 5;

   println("X is Equal to Y : "+ (X == Y));
   println("X is not Equal to Y : "+ (X != Y));
   println("X is more than Y : "+ (X > Y));
   println("X is less than Y : "+ (X < Y));
   println("X is more than or equal to Y : "+ (X >= Y));
   println("X is less than or equal to Y : "+ ( X <= Y));

}
            """.trimIndent(),
            type = "Program"
        ),



        // Selections
        ContentEntity(
            name = "Selections",
            title = "Else If ladder",
            content = """
                fun main() {

  var abc = 10;
  var xyz = 10;

  if (abc > xyz) {
    println("ABC is More to XYZ");
  } else if (abc < xyz) {
    println("ABC is Less to XYZ");
  } else {
    println("ABC is Equal to XYZ");
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Selections",
            title = "If Else",
            content = """
                fun main() {

  var abc = 10;
  var xyz = 15;

  if (abc == xyz) {
    println("ABC is Equal to XYZ");
  } else {
    println("ABC is Not Equal to XYZ");
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Selections",
            title = "Nested If",
            content = """
                fun main() {

  int abc = 10;
  int pqr = 15;
  int xyz = 20;

  if (abc > pqr) {

    if (abc > xyz) {
      println("ABC is Highest");
    } else {
      println("XYZ is Highest");
    }

  } else {

    if (pqr > xyz) {
      println("PQR is Highest");
    } else {
      println("XYZ is Highest");
    }

  }
}

            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Selections",
            title = "Simple If",
            content = """
                fun main() {

  var abc = 10;
  var xyz = 15;

  if (abc < xyz) {
    println("Kotlin");
  }
  if (abc > xyz) {
    println("Hello World");
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Selections",
            title = "When",
            content = """
                fun main() {
  var abc = 3
  when (abc) {
    1 -> println("ABC = 1")
    2 -> println("ABC = 2")
	3 -> println("ABC = 3")
	4 -> println("ABC = 4")
    else ->
     println("ABC is not equal to 1,2,3 or 4")
  }
}
            """.trimIndent(),
            type = "Program"
        ),


        // Iteration
        ContentEntity(
            name = "Iteration",
            title = " Do-While Loop",
            content = """
                fun main() {

  var abc = 5;

  do {
    abc = abc - 1;
    println("ABC = "+ abc);
  } while (abc > 0);

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Iteration",
            title = " For In Loop",
            content = """
                fun main() {
    var languages = arrayOf(
      "C",
      "C++",
      "Java",
      "JavaScript",
      "PHP",
      "Python"
    )
    for(element in languages) {
       println("Language : "+ element)
    }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Iteration",
            title = " Nested Loop",
            content = """
                fun main() {

  var i = 0
  while (i <= 5) {

    var j = 0
    while (j < i) {
      print("*")
      j++
    }

    println()
    i++  
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Iteration",
            title = " While Loop",
            content = """
                fun main() {

  var abc = 5;

  while (abc > 0) {
    println("ABC = "+ abc)
    abc = abc - 1;
  }
}
            """.trimIndent(),
            type = "Program"
        ),


        // Other Resources
        ContentEntity(
            name = "Other Resources",
            title = "break Keyword",
            content = """
                fun main() {

  var abc = 10

  while (abc > 0) {
    abc = abc - 1
    println("ABC Value is "+ abc)

    if (abc == 6) {
      break
    }

  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Other Resources",
            title = "continue Keyword",
            content = """
                fun main() {
  var abc = 10

  while (abc > 0) {
    abc = abc - 1

    if (abc == 6) {
      continue
    }

    println("ABC Value is " + abc);
  }
}
            """.trimIndent(),
            type = "Program"
        ),

        // Functions
        ContentEntity(
            name = "Functions",
            title = "Function",
            content = """
                fun main() {
  printMessage();
  println("Hello World!");
}

fun printMessage() {
  println("Kotlin");
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Functions",
            title = "Passing Values to Function",
            content = """
                fun main() {
  var num1 = 10;
  var num2 = 20;
  sum(num1, num2);
}

fun sum(a: Int, b: Int) {
  var ans = a + b;
  println("Answer : "+ ans);
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Functions",
            title = "Recursive Function",
            content = """
                fun main() {

  var num = 10;
  var ans = add(num);
  println("Sum of Numbers = "+ ans);
}

fun add(n: Int) : Int{

  if (n != 0)
    return n + add(n - 1) //Return Value is the Function itself
  else
    return n
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Functions",
            title = "Returning Values from Function",
            content = """
                fun main() {

  var num1 = 10
  var num2 = 15
  var returnValue = sum(num1, num2)
  println("Answer : "+ returnValue)

}

fun sum(a: Int, b: Int) :Int {

  var ans = a + b
  return ans
}
            """.trimIndent(),
            type = "Program"
        ),


        // Arrays
        ContentEntity(
            name = "Arrays",
            title = "1-D Array",
            content = """
                fun main() {

  var myArray = arrayOf(1, 5, 7, 2, 3, 8, 4, 9, 6, 0)

  var i = 0
  while (i < 10) {
    println(myArray[i]);
    i++
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Arrays",
            title = "2-D Array",
            content = """
                fun main() {

  var num1 = arrayOf(1, 5, 7)
  var num2 = arrayOf(2, 3, 8)
  var myArr = arrayOf(num1, num2)

  var i = 0
  while (i < 2) {

    var j = 0 
    while (j < 3) {
      println(myArr[i][j])
      j++
    }

    i++
  }
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Arrays",
            title = "Array",
            content = """
                fun main() {

  var num = arrayOf(1, 5, 7, 2, 3, 8, 4, 9, 6, 0)

  println("1st Number : "+ num[0]);
  println("2nd Number : "+ num[1]);
  println("3rd Number : "+ num[2]);
  println("4th Number : "+ num[3]);
  println("5th Number : "+ num[4]);
  println("6th Number : "+ num[5]);
  println("7th Number : "+ num[6]);
  println("8th Number : "+ num[7]);
  println("9th Number : "+ num[8]);
  println("10th Number : " + num[9]);
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Arrays",
            title = "Types of Array",
            content = """
                fun main() {

  var arr1 = arrayOf(1, 5, 7, 2) // 1-D Array
  var arr2 = arrayOf(1, 5, 7, 2) // 1-D Array
  
  var arrMulti = arrayOf(arr1, arr2) // 2-D Array

}
            """.trimIndent(),
            type = "Program"
        ),

        // Strings
        ContentEntity(
            name = "Strings",
            title = "MultiLine String",
            content = """
                fun main() {

   var str = "OnePercent"
   println(str)
    
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "Strings",
            content = """
                fun main() {

   var str = "OnePercent"
   println(str)
    
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "CompareTo()",
            content = """
                fun main() {

   var str1 = "OnePercent".compareTo("ABC") 
   var str2 = "OnePercent".compareTo("OnePercent") 
   var str3 = "OnePercent".compareTo("onepercent") 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "Contains()",
            content = """
                fun main() {

   var str1 = "OnePercent".contains("one") 
   var str2 = "OnePercent".contains("One") 
   var str3 = "OnePercent".contains("ONE") 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "count()",
            content = """
                fun main() {

   var str1 = "OnePercent".count() 
   var str2 = "One Percent".count() 
   var str3 = "Welcome to the OnePerecnt".count() 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "drop()",
            content = """
                fun main() {

   var str1 = "OnePercent".drop(3) 
   var str2 = "OnePercent".drop(9) 
   var str3 = "Welcome to the OnePerecnt".drop(15) 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "dropLast()",
            content = """
                fun main() {

   var str1 = "OnePercent".dropLast(7) 
   var str2 = "OnePercent".dropLast(1) 
   var str3 = "Welcome to the OnePerecnt".dropLast(9) 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "get()",
            content = """
                fun main() {

   var str1 = "OnePercent".get(0) 
   var str2 = "OnePercent".get(3) 
   var str3 = "OnePercent".get(5) 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "indexOf()",
            content = """
                fun main() {

   var str1 = "OnePercent".indexOf("X") 
   var str2 = "OnePercent".indexOf("O") 
   var str3 = "OnePerecnt".indexOf("p") 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "plus()",
            content = """
                fun main() {

   var str1 = "One".plus("Percent") 
   var str2 = "One".plus(" Percent") 
   var str3 = "One ".plus("Percent") 
   
   println(str1)
   println(str2)
   println(str3)

}   
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "subSequence()",
            content = """
                fun main() {

   var str1 = "OnePercent".subSequence(0,3) 
   var str2 = "OnePercent".subSequence(3,6) 
   var str3 = "OnePercent".subSequence(0,10) 
   
   println(str1)
   println(str2)
   println(str3)

}   
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "toLowerCase()",
            content = """
                fun main() {

   var str1 = "OnePercent".toLowerCase() 
   var str2 = "ONEPERCENT".toLowerCase() 
   var str3 = "oneperecnt".toLowerCase() 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Strings",
            title = "toUpperCase()",
            content = """
                fun main() {

   var str1 = "OnePercent".toUpperCase() 
   var str2 = "ONEPERCENT".toUpperCase() 
   var str3 = "oneperecnt".toUpperCase() 
   
   println(str1)
   println(str2)
   println(str3)

}
            """.trimIndent(),
            type = "Program"
        ),

        // Math
        ContentEntity(
            name = "Math",
            title = "abs()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.abs(100.0) 
   var val2 = Math.abs(-100.0) 
   var val3 = Math.abs(0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "acos()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.acos(1.0) 
   var val2 = Math.acos(-1.0) 
   var val3 = Math.acos(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "asin()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.asin(10.0) 
   var val2 = Math.asin(-10.0) 
   var val3 = Math.asin(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "atan()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.atan(1.0) 
   var val2 = Math.atan(-1.0) 
   var val3 = Math.atan(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "cbrt()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.cbrt(125.0) 
   var val2 = Math.cbrt(0.0) 
   var val3 = Math.cbrt(5.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "cos()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.cos(10.0) 
   var val2 = Math.cos(-10.0) 
   var val3 = Math.cos(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "cosh()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.cosh(1.0) 
   var val2 = Math.cosh(-1.0) 
   var val3 = Math.cosh(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "exp()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.exp(100.0) 
   var val2 = Math.exp(-100.0) 
   var val3 = Math.exp(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "log()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.log(100.0) 
   var val2 = Math.log(-100.0) 
   var val3 = Math.log(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "log10()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.log10(100.0) 
   var val2 = Math.log10(-100.0) 
   var val3 = Math.log10(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "max()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.max(100.0, 250.0) 
   var val2 = Math.max(100.0, 100.0) 
   var val3 = Math.max(100.0, -100.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "min()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.min(100.0, 250.0) 
   var val2 = Math.min(100.0, 100.0) 
   var val3 = Math.min(100.0, -100.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "pow()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.pow(100.0, 2.0) 
   var val2 = Math.pow(100.0, -2.0) 
   var val3 = Math.pow(100.0, 0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "round()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.round(100.25) 
   var val2 = Math.round(99.5) 
   var val3 = Math.round(100.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "sin()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.sin(10.0) 
   var val2 = Math.sin(-10.0) 
   var val3 = Math.sin(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "sinh()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.sinh(1.0) 
   var val2 = Math.sinh(-1.0) 
   var val3 = Math.sinh(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "sqrt()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.sqrt(100.0) 
   var val2 = Math.sqrt(0.0) 
   var val3 = Math.sqrt(3.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "tan()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.tan(10.0) 
   var val2 = Math.tan(-10.0) 
   var val3 = Math.tan(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Math",
            title = "tanh()",
            content = """
                import kotlin.math.abs

fun main() {

   var val1 = Math.tanh(1.0) 
   var val2 = Math.tanh(-1.0) 
   var val3 = Math.tanh(0.0) 
   
   println(val1)
   println(val2)
   println(val3)

}
            """.trimIndent(),
            type = "Program"
        ),


        // OOPs Concepts
        ContentEntity(
            name = "OOPs Concepts",
            title = "Abstract Class",
            content = """
                open class BaseClass {  
   open fun run() {  
     println("Base Class")  
   }  
}  
abstract class AbstractClass : BaseClass() {  
   override abstract fun run()  
}  
class DerivedClass: AbstractClass(){  
   override fun run() {  
     println("Derived Class")  
   }  
}  
fun main(args: Array<String>){  
  val obj1 = BaseClass()  
  obj1.run()  
  val obj2 = DerivedClass()  
  obj2.run()  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "OOPs Concepts",
            title = "Constructor",
            content = """
                class ConstructoExample {  
  constructor(name: String, id: Int){  
     println("Name = "+ name)  
     println("Id = "+ id)  
  }  
}  

fun main(args: Array<String>){  
   val ConstructoExample = ConstructoExample ("Akash", 100)  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "OOPs Concepts",
            title = "Inheritance",
            content = """
                open class BaseClass {  
   fun BasePrint() {  
     println("Base Class")  
   }  
}  
class DerivedClass: BaseClass() {  
   fun DerivedPrint() {  
     println("Derived Class")  
   }  
}  

fun main(args: Array<String>) {  
  val obj = DerivedClass()  
  obj.BasePrint()   
  obj.DerivedPrint()  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "OOPs Concepts",
            title = "Interface",
            content = """
                interface MyInterface  {  
  var id: Int
  fun InterfaceReturn():String
  fun printMessage() {  
    println("Interface")  
  }  
}  
class InterfaceImp : MyInterface {  
  override var id: Int = 100
  override fun InterfaceReturn(): String{  
     return "Derived Class ID : " + id
  }  
}  
fun main(args: Array<String>) {  
  val obj = InterfaceImp()  
  obj.printMessage()  
  println(obj.InterfaceReturn())  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "OOPs Concepts",
            title = "Polymorphism",
            content = """
                fun function(n : String){
    println("String Passed")
}
fun function(n : Int){
    println("Integer Passed")
}
fun function(n : Double){
    println("Double Passed")
}
fun main(){
   function(10)
   function(10.0)
   function("10")
}
            """.trimIndent(),
            type = "Program"
        ),

        // Errors
        ContentEntity(
            name = "Errors",
            title = "Compile-Time Errors",
            content = """
                fun main() {

    Println("OnePercent") // Uppercase P

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Errors",
            title = "Logical Errors",
            content = """
                fun main() {

  var X = 10;
  if (X < 0) {
     println("X is a Positive Integer");
  }
  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Errors",
            title = "Run-Time Errors",
            content = """
                fun main() {

    var num = 10
    var div = 0
    var result = num / div

    println("Answer : " + result);

}
            """.trimIndent(),
            type = "Program"
        ),

        // Exception Handling
        ContentEntity(
            name = "Exception Handling",
            title = "Try-Catch Block",
            content = """
                fun main() {

    Println("OnePercent") // Uppercase P

}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Exception Handling",
            title = "finally Keyword",
            content = """
                fun main() {

  var X = 10;
  if (X < 0) {
     println("X is a Positive Integer");
  }
  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "Exception Handling",
            title = "throw Keyword",
            content = """
                fun main() {

    var num = 10
    var div = 0
    var result = num / div

    println("Answer : " + result);

}
            """.trimIndent(),
            type = "Program"
        ),

        // File Handling
        ContentEntity(
            name = "File Handling",
            title = "Create a File",
            content = """
                fun main() {

   var num1 = 100;
   var num2 = 0;
   var result = 0;

   try {
     result = num1 / num2;
   }
   catch(exception: ArithmeticException) {
     println("Cannot Divide by 0");
   }
  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "File Handling",
            title = "Read from a File",
            content = """
                fun main() {

   var num1 = 100;
   var num2 = 0;
   var result = 0;

   try {
     result = num1 / num2;
   }
   catch(exception: ArithmeticException) {
     println("Cannot Divide by 0");
   }
   finally{
     println("Execution Completed");
   }
  
}
            """.trimIndent(),
            type = "Program"
        ),
        ContentEntity(
            name = "File Handling",
            title = "Write into a File",
            content = """
                fun main() {

   var age = 15;

   if (age < 18){
      throw ArithmeticException("Not Allowed")
   }
  
}
            """.trimIndent(),
            type = "Program"
        ),
    )
}
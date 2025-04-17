package com.example.gds.beginkotlineasy.features.feature_program_syntax.data_layer.model

// Object file for Syntax Data
object SyntaxData {
    val topics = listOf(
        // Basic Concept
        ContentEntity(
            name = "Basic Concept",
            title = "Comments",
            content = """
                // <Comment>
/* <Comment>*/
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Basic Concept",
            title = "Input and Output State",
            content ="""
                print(<YOUR_TEXT>)
var <VariableName> = readLine()
            """.trimIndent(),
            type = "Syntax"
        ),

        // DataTypes
        ContentEntity(
            name = "DataTypes",
            title = "Array DataType",
            content = """
                arrayOf(<ArrayElements>)
arrayOf(<Array1>, <Array2>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Boolean DataType",
            content = """
                var <Variable> = <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Character DataType",
            content = """
                var <Variable> = <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Float DataType",
            content = """
                var <Variable> = <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "Integer DataType",
            content = """
                var <Variable> = <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "DataTypes",
            title = "String DataType",
            content = """
                var <Variablename> = <Value>
            """.trimIndent(),
            type = "Syntax"
        ),


        // Operators
        ContentEntity(
            name = "Operators",
            title = "Arithmetic Operator",
            content = """
                <Value> + <Value>
<Value> - <Value>
<Value> * <Value>
<Value> / <Value>
<Value> % <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Operators",
            title = "Assignment Operator",
            content = """
                <Variable> = <Value>
<Variable> += <Value>
<Variable> -= <Value>
<Variable> *= <Value>
<Variable> /= <Value>
<Variable> %= <Value>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Operators",
            title = "Bitwise Operator",
            content = """
                <Value> & <Value>
<Value> | <Value>
<Value> ^ <Value>
~ <Value>
<Value> <<
<Value> >>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Operators",
            title = "Increment and Decrement Operator",
            content = """
                <Value> ++
<Value> --
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Operators",
            title = "Logical Operator",
            content = """
                <Condition> && <Condition>
<Condition> || <Condition>
!<Condition>
            """.trimIndent(),
            type = "Syntax"
        ),

        ContentEntity(
            name = "Operators",
            title = "Relational Operator",
            content = """
                 <Value> == <Value>
<Value> != <Value>
<Value> < <Value>
<Value> > <Value>
<Value> <= <Value>
<Value> >= <Value>
            """.trimIndent(),
            type = "Syntax"
        ),



        // Selections
        ContentEntity(
            name = "Selections",
            title = "Else If ladder",
            content = """
                if(<Condition>){
  <Code>
} else if(<Condition>){
  <Code>
}else{
  <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Selections",
            title = "If Else",
            content = """
                if (<Condition>){
  <Code>
} else {
  <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Selections",
            title = "Nested If",
            content = """
               if(<Condition>){
  if(<Condition>){
    <Code>
  }
 <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Selections",
            title = "Simple If",
            content = """
                if (<Condition>){
  <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Selections",
            title = "When",
            content = """
               when(<Value>){
  <ValueComparison> ->
      <Code>
 <ValueComparison> ->
      <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),


        // Iteration
        ContentEntity(
            name = "Iteration",
            title = " Do-While Loop",
            content = """
                do {
  <Code>
} while (<Condition>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Iteration",
            title = " For In Loop",
            content = """
                for (<Item> in <Array>)  {
 // Code
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Iteration",
            title = " Nested Loop",
            content = """
                while (<Condition>) {
  while (<Condition>) {
   <Code>
  }
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Iteration",
            title = " While Loop",
            content = """
                while (<Condition>){
  <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),



        // Functions
        ContentEntity(
            name = "Functions",
            title = "Function",
            content = """
                <Variable> = <FunctionName>()
fun <FunctionName>() : <DataType>{
  <Code>
  return <Data>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Functions",
            title = "Passing Values to Function",
            content = """
                fun <FunctionName>(){
  <Code>
  <FunctionName>
}
<FunctionName>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Functions",
            title = "Recursive Function",
            content = """
                fun <FunctionName>(<Arguements>)
<ReturnType> <FunctionName> (<Parameters>:<DataType>){
  // Code
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Functions",
            title = "Returning Values from Function",
            content = """
                fun <FunctionName>(<Arguements>)
<ReturnType> <FunctionName> (){
  // Code
}
            """.trimIndent(),
            type = "Syntax"
        ),


        // Arrays
        ContentEntity(
            name = "Arrays",
            title = "1-D Array",
            content = """
               arrayOf(<ArrayElements>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Arrays",
            title = "2-D Array",
            content = """
                arrayOf(<Array1>, <Array2>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Arrays",
            title = "Array",
            content = """
               arrayOf(<ArrayElements>)
arrayOf(<Array1>, <Array2>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Arrays",
            title = "Types of Array",
            content = """
               arrayOf(<ArrayElements>)
arrayOf(<Array1>, <Array2>)
            """.trimIndent(),
            type = "Syntax"
        ),

        // Strings
        ContentEntity(
            name = "Strings",
            title = "MultiLine String",
            content = """
                ""${'"'}
<Data>
<Data>
""${'"'}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "Strings",
            content = """
                var <VariableName> = <StringValue>
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "CompareTo()",
            content = """
               <String>.compareTo(<String>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "Contains()",
            content = """
               <String>.contains(<String>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "count()",
            content = """
               <String>.count()
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "drop()",
            content = """
                <String>.drop(<Index>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "dropLast()",
            content = """
                <String>.drop(<index>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "get()",
            content = """
                <String>.get(<Index>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "indexOf()",
            content = """
                <String>.indexOf(<Substring>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "plus()",
            content = """
               <String>.plus(<String>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "subSequence()",
            content = """
               <String>.subSequence(<StartingIndex>, <EndingIndex>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "toLowerCase()",
            content = """
                <String>.toLowerCase()
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Strings",
            title = "toUpperCase()",
            content = """
                <String>.toUpperCase()
            """.trimIndent(),
            type = "Syntax"
        ),


        // Math
        ContentEntity(
            name = "Math",
            title = "abs()",
            content = """
                Math.abs(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "acos()",
            content = """
                Math.acos(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "asin()",
            content = """
                Math.asin(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "atan()",
            content = """
                Math.atan(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "cbrt()",
            content = """
                Math.cbrt(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "cos()",
            content = """
                Math.cosine(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "cosh()",
            content = """
                Math.cosh(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "exp()",
            content = """
                Math.exp(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "log()",
            content = """
                Math.log(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "log10()",
            content = """
                Math.log10(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "max()",
            content = """
                Math.max(<Value1>, <Value2>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "min()",
            content = """
                Math.min(<Value1>, <Value2>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "pow()",
            content = """
                Math.pow(<Base>, <Power>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "round()",
            content = """
                Math.round(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "sin()",
            content = """
               Math.sin(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "sinh()",
            content = """
               Math.sinh(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "sqrt()",
            content = """
                Math.sqrt(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "tan()",
            content = """
                Math.tan(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Math",
            title = "tanh()",
            content = """
                Math.tanh(<Value>)
            """.trimIndent(),
            type = "Syntax"
        ),


        // Exception Handling
        ContentEntity(
            name = "Exception Handling",
            title = "Try-Catch Block",
            content = """
                try{
  <Code>
}catch(<Variable>: <ExceptionTyple> ){
  <Code>
}
            """.trimIndent(),
            type = "Syntax"
        ),
        ContentEntity(
            name = "Exception Handling",
            title = "throw Keyword",
            content = """
                                throw <Exception>(<Message>)
            """.trimIndent(),
            type = "Syntax"
        ),

        )
}

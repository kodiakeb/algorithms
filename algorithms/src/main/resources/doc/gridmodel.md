Thinking about Grid
===================

Think about different views on the grid
* Entire grid as a matrix
* An individual square/value
* A group of 9 values
* 9 rows
* 9 columns
* 9 boxes
* Each box has 3 rows of values
* Each box has 3 columns of values
* The entire grid has 3 rows of boxes
* The entire grid row has 3 columns of boxes

Value is an individual number is a sudoku.
It has various properties:
State - the current state
PotentialStates - the list of states that it could have in the future.
boolean value for givenValue: true if it were supplied as non-empty
isComplete() will return true if a completed state.

Matrix is an implementation of grid
Has 9 x 9 values and a means of referencing them.

Group is a group of Nine and a method for cycling through
nine values.

Row is a Group.

Column is a Group

Box is a Group

BoxGroup is 3 boxes

BoxRow is a BoxGroup

BoxColumn is a BoxGroup

ValueGroup is 3 Values

ValueRow is a ValueGroup

ValueColumn is a ValueGroup

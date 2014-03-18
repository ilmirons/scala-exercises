import scala.collection.immutable.Nil

object nQueens extends App {

	val N = 8
	
	type Position = (Int, Int)
	type Board = List[Position]
	
	val board = for {
		i <- 0 to N
		j <- 0 to N
	} yield (i, j)
	
	def updateAvailable (pos: Position, board: Board) = {
	  board.filter( _ match {
	    case (pos._1, _) => false
	    case (_, pos._2) => false
	    case (i, j) => !( i + j == pos._1 + pos._2 || 
	        i - j == pos._1 - pos._2)
	  })
	}
	// TODO: define a infix or operator for Board that 
	// return second argument if 1st is Nil.
	// use call by name to skip computation
	// do we have to extend type?
	def ||(that: Board) = {
	  
	}

	def solve(available: Board, queens: Int, pos: Position, solution: Board): Board = {
	  
	  if (queens == 0) solution else
	  if (available.length == 0) Nil else 
	  solve(updateAvailable(pos, available), queens - 1, pos, pos :: solution) ||
	  solve(available, queens, available.tail.head, solution)
	}

}
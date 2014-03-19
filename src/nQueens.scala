import scala.collection.immutable.Nil

object nQueens extends App {

	val N = args(0) toInt
	
	type Position = (Int, Int)
	type Board = List[Position]
	
	val board = (for {
		i <- 0 until N 
		j <- 0 until N
	} yield (i, j)) toList
	
	def updateAvailable (pos: Position, board: Board) = {
	  board.filter( _ match {
	    case (pos._1, _) => false
	    case (_, pos._2) => false
	    case (i, j) => !( i + j == pos._1 + pos._2 || 
	        i - j == pos._1 - pos._2)
	  })
	}
	
	def solve(available: Board, queens: Int,
	    solution: Option[Board] = Some(Nil)): Option[Board] = {
	  
	  if (queens == 0) solution else
	  if (available.length == 0) None else {
		  solve(updateAvailable(available.head, available), 
		        queens - 1, 
		        solution.map((sol) => available.head :: sol)) match {
		    case Some(board) => Some(board)
		    case None => solve(available.tail, queens, solution)
		  }
	  }
	}
	
	print(solve(board, N))
}



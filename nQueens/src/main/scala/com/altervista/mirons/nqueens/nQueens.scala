import scala.collection.immutable.Nil

trait nQueen {
  
  type Position
  type Board    <: Seq[Position]
  type Solution =  Option[Board]
  
  def mkBoard(n: Int): Board
  
  def updateAvailablePositions[T <: Seq[Position]](pos: Position, board: T): Seq[Position]
  
  def updateSolution(sol: Solution, p: Position): Solution
  
  def printSolution(b: Board) {
    print(b)
  } 
  
  def solve[T <: Seq[Position]](available: T, queens: Int,
	    sol: Solution): Solution = {
	  
	  if (queens == 0) sol else
	  if (available.length == 0) None else {
		  solve(updateAvailablePositions(available.head, available), 
		        queens - 1, 
		        updateSolution(sol, available.head)) match {
		    case Some(solution) => Some(solution)
		    case None => solve(available.tail, queens, sol)
		  }
	  }
	}
}

object nQueens extends App with nQueen {

	val N = args(0) toInt
	
	type Position = (Int, Int)
	type Board    = List[Position]
	
	val board = mkBoard(N)
	
	def mkBoard(n: Int) = {
		(for {
			i <- 0 until N 
			j <- 0 until N
		} yield (i, j)) toList 
	}
	
	def updateAvailablePositions[T <: Seq[Position]] (pos: Position, board: T) = {
	  board.filter( _ match {
	    case (pos._1, _) => false
	    case (_, pos._2) => false
	    case (i, j) => !( i + j == pos._1 + pos._2 || 
	        i - j == pos._1 - pos._2)
	  })
	}
	
	def updateSolution(sol: Solution, p: Position): Solution = {
	  sol.map(board => p :: board)
	}
	
	solve(board, N, Some(Nil)) match {
	  case None           => print("No solution found :(")
	  case Some(solution) => printSolution(solution)
	}
}

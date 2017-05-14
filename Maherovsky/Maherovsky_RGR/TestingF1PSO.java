import eva2.OptimizerFactory ;
import eva2.problems.F1Problem ;

public class TestingF1PSO {
	public static void main ( String [ ] args ) {
		F1Problem f1 = new F1Problem ( ) ;
		double [ ] sol ;
		OptimizerFactory.setEvaluationTerminator ( 50000 ) ;
		sol = OptimizerFactory.optimizeToDouble ( OptimizerFactory .PSO, f1 , null ) ;
		System.out.println( "Found solution : " ) ;
		for ( int i =0; i<f1.getProblemDimension ( ) ; i++) System.out.print (sol[ i ] + " " ) ;
		System.out.println ( ) ;
	} ;
}

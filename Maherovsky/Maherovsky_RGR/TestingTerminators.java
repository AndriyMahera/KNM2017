import eva2.OptimizerFactory ;
import eva2.server.go.problems.F1Problem ;
import eva2.server.go.operators.terminators;

public class TestingTerminators {
	public static void main ( St r ing [ ] args ) {
		F1Problem f1 = new F1Problem ( ) ;
		double [ ] sol ;
		// A combined terminator for fitness and phenotype convergence
		CombinedTerminator convT = new CombinedTerminator (
		// fitness−based stagnation period , absolute threshold
		new FitnessConvergenceTerminator ( 0.0 0 0 1 , 1000 , true , true ) ,
		new PhenotypeConvergenceTerminator ( 0.0 0 0 1 , 1000 , true , true ) ,
		CombinedTerminator .AND) ;
		// Adding an e valuat ion terminator with OR to the convergence c r i t e r i o n
		OptimizerFactory.setTerminator (new CombinedTerminator (
		new EvaluationTerminator (20000) ,
		convT ,
		CombinedTerminator .OR) ) ;
		sol = OptimizerFactory.optimizeToDouble ( OptimizerFactory.PSO, f1 , null ) ;
		System.out.println ( OptimizerFactory.terminatedBecause ( ) ) ;
		System.out.println ( OptimizerFactory.las tEval sPe r formed ( )
		+ " e v a l s performed , found s o l u t i o n : "
		+ OptimizerFactory.terminatedBecause ( )
		+ " Found s o l u t i o n : " ) ;
		for ( int i =0; i<f 1.getProblemDimension ( ) ; i++) System.out.print( sol[ i ] + " " ) ;
		System.out.println( ) ;
	} ;
}

import eva2.OptimizerFactory ;
import eva2.server.go.individuals.AbstractEAIndividual ;
import eva2.server.go.operators.crossover.CrossoverESDefault ;
import eva2.server.go.operators.mutation.MutateESCovarianceMartixAdaption ;
import eva2.server.go.operators.terminators.EvaluationTerminator ;
import eva2.server.go.problems.FM0Problem;
import eva2.server.go.strategies.EvolutionStrategies ;
import eva2.server.modules.GOParameters ;

public class TestingPlusCMAES {
	public static void main ( String [ ] args ) {
		// a simple bimodal target function , two optima
		FM0Problem fm0 = new FM0Problem ( ) ;
		AbstractEAIndividual bestIndy ;
		// create standard ES parameters
		GOParameters esParams = OptimizerFactory.standardES ( fm0 ) ;
		esParams.setTerminator (new EvaluationTerminator ( 2 0 0 0 ) ) ;
		// set a random seed based on system time
		esParams.setSeed ( 0 ) ;
		
		// set e volutionary operators and probabilities
		AbstractEAIndividual.setOperators (
		fm0.getIndividualTemplat e ( ) ,
		new MutateESCovarianceMartixAdaption ( ) , 0.9 ,
		new CrossoverESDefault ( ) , 0.1 ) ;
		
		// access the ES
		EvolutionStrategieses = (EvolutionStrategies)esParams.getOptimizer ( ) ;
		// set a (1+5) selection strategy
		es.setMu ( 1 ) ;
		es.setLambda ( 5 ) ;
		es.setPlusStrategy ( true ) ;
		
		// run optimization and retrieve winner individual
		bestIndy = ( AbstractEAIndividual ) OptimizerFactory.optimizeToInd ( esParams , null ) ;
		System.out.println ( "Found solution : "
		+ AbstractEAIndividual.getDefaultDataString ( bestIndy ) ) ;
	} ;
}

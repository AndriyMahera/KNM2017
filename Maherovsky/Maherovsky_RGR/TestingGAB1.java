import java.util.BitSet;
import eva2.problems.B1Problem;
import eva2.OptimizerFactory;
import eva2.optimization.OptimizationParameters;
import eva2.optimization.operator.selection.InterfaceSelection;
import eva2.optimization.operator.selection.SelectTournament;
import eva2.optimization.operator.selection.SelectXProbRouletteWheel;
import eva2.optimization.operator.terminators.*;
import eva2.optimization.population.*;
import eva2.optimization.strategies.GeneticAlgorithm;


public class TestingGAB1 {
	public static void main ( String [ ] args ) {
		B1Problem b1 = new B1Problem ( ) ;
		BitSet sol ;
		// default go−parameter instance with a GA
		OptimizationParameters gaParams = OptimizerFactory.standardGA(b1);
		// add an evaluation terminator
		gaParams.setTerminator (new EvaluationTerminator (1000) ) ;
		// set a specific random seed
		gaParams.setRandomSeed(2342);


		// access the GA
		GeneticAlgorithm ga = ( GeneticAlgorithm ) gaParams.getOptimizer();
		// set no elitism
		ga.setElitism( false ) ;
		// set roulette wheel selection
		ga.setParentSelection(new SelectXProbRouletteWheel()) ;
		// set population size 150
		ga.setPopulation(new Population ( 150 )) ;

		// run optimization and print intermediate results to a file with given prefix
		sol = OptimizerFactory.optimizeToBinary( gaParams , "ga−opt−results " ) ;
		System.out.println( "Found solution : " ) ;
		for ( int i =0; i<b1.getProblemDimension ( ) ; i++) System.out.print(sol.get( i )+" " ) ;
		System.out.println( ) ;
	} ;
}

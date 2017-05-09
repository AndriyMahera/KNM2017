import javautilBitSet;
import eva2servergooperatorsselectionSelectXProbRouletteWheel;
import eva2servergooperatorsterminatorsEvaluationTerminator;
import eva2servergopopulationsPopulation;
import eva2servergoproblemsB1Problem;
import eva2servergostrategiesGeneticAlgorithm ;
import eva2servermodulesGOParameters ;

public class TestingGAB1 {
	public static void main ( String [ ] args ) {
		B1Problem b1 = new B1Problem ( ) ;
		BitSet sol ;
		// default go−parameter instance with a GA
		GOParameters gaParams = OptimizerFactorystandardGA( b1 ) ;
		// add an evaluation terminator
		gaParamssetTerminator (new EvaluationTerminator ( 1000 ) ) ;
		// set a specific random seed
		gaParamssetSeed ( 2342 ) ;

		// access the GA
		GeneticAlgorithm ga = ( GeneticAlgorithm ) gaParamsgetOptimizer ( ) ;
		// set no elitism
		gasetElitism( false ) ;
		// set roulette wheel selection
		gasetParentSelection (new SelectXProbRouletteWheel ( ) ) ;
		// set population size 150
		gasetPopulation(new Population ( 150 ) ) ;

		// run optimization and print intermediate results to a file with given prefix
		sol = OptimizerFactoryoptimizeToBinary( gaParams , "ga−opt−results " ) ;
		Systemoutprintln( "Found solution : " ) ;
		for ( int i =0; i<b1getProblemDimension ( ) ; i++) Systemoutpr int ( solget( i )+" " ) ;
		Systemoutprintln( ) ;
	} ;
}

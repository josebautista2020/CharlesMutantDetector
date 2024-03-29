package org.charles.mutantDetector.business.mutantDetector.impl;

import org.charles.mutantDetector.business.mutantDetector.coordinates.Coordinates;

public class ObliqueHorizontalSequenceDetectorImpl extends AbstractFixedSequenceWithConsecutiveCharactersDetectorImpl {

	
	public ObliqueHorizontalSequenceDetectorImpl(int sequenceLength) {
		super(sequenceLength);
	}

	
	@Override
	public Coordinates transformToCoordinate(int sequenceIndexToSearchIn, int characterPosition) {
		return new Coordinates(sequenceIndexToSearchIn+1 + characterPosition, characterPosition);
	}
	

	

}

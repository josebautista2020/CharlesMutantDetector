package org.charles.mutantDetector.business.mutantDetector.impl;

import org.charles.mutantDetector.business.mutantDetector.coordinates.Coordinates;

public class ObliqueVerticalSequenceDetectorImpl extends AbstractFixedSequenceWithConsecutiveCharactersDetectorImpl {

	public ObliqueVerticalSequenceDetectorImpl(int sequenceLength) {
		super(sequenceLength);
	}


	@Override
	public Coordinates transformToCoordinate(int sequenceIndexToSearchIn, int characterPosition) {
		return new Coordinates(characterPosition, sequenceIndexToSearchIn+characterPosition);
	}
}

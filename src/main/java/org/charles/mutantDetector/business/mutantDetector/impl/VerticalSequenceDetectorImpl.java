package org.charles.mutantDetector.business.mutantDetector.impl;

import org.charles.mutantDetector.business.mutantDetector.coordinates.Coordinates;

public class VerticalSequenceDetectorImpl extends AbstractFixedSequenceWithConsecutiveCharactersDetectorImpl {

	public VerticalSequenceDetectorImpl(int sequenceLength) {
		super(sequenceLength);
	}


	@Override
	public Coordinates transformToCoordinate(int sequenceIndexToSearchIn, int characterPosition) {
		return new Coordinates(sequenceIndexToSearchIn, characterPosition);
	}

}

package lotto.model;

import lotto.constants.Rank;

public class WinLotto {
	private final Lotto lotto;
	private final int bonusNumber;

	public WinLotto(Lotto lotto, int bonusNumber) {
		this.lotto = lotto;
		this.bonusNumber = bonusNumber;
	}

	public Rank compare(Lotto lotto) {
		int sameCount = this.lotto.compareNumbers(lotto);

		return Rank.valueOf(sameCount, lotto.contains(bonusNumber));
	}
}
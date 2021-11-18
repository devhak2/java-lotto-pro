package lotto.util;

import static lotto.constants.LottoConstants.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;

public class LottoGenerator {
	private static final List<LottoNumber> LOTTO_NUMBERS;
	private static final int LOTTO_PICKED = 6;

	static {
		LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public static Lotto generateAuto() {
		Collections.shuffle(LOTTO_NUMBERS);
		return new Lotto(LOTTO_NUMBERS.stream()
			.limit(LOTTO_PICKED)
			.sorted()
			.collect(Collectors.toList()));
	}

	public static Lottos purchaseLottos(int numberOfAutoCreation) {
		return new Lottos(IntStream.range(0, numberOfAutoCreation)
			.mapToObj(i -> LottoGenerator.generateAuto())
			.collect(Collectors.toList()));
	}

	private LottoGenerator() {
	}
}

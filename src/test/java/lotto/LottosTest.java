package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PurchaseMoney;
import lotto.model.WinLotto;
import lotto.util.LottoGenerator;

public class LottosTest {
	@Test
	@DisplayName("구매 비용에 따른 로또 구매 갯수 비교 테스트")
	void purchaseLottos() {
		PurchaseMoney money = new PurchaseMoney(14000);
		Lottos lottos = LottoGenerator.purchaseLottos(money.purchase());
		assertThat(lottos.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("각 로또의 등수 계산 테스트")
	void winPrize() {
		WinLotto winLotto = new WinLotto(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)), 10);
		Lotto lottoFirst = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		Lotto lottoSecond = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 10));

		Lottos lottos = new Lottos(Arrays.asList(lottoFirst, lottoSecond));
		assertThat(lottos.winPrize(winLotto)).isEqualTo(Prize.withRankList(Arrays.asList(Rank.FIRST, Rank.SECOND)));
	}
}

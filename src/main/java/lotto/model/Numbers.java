package lotto.model;

import java.util.List;
import java.util.Objects;

public class Numbers {
	private final List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int size() {
		return numbers.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Numbers numbers1 = (Numbers)o;
		return Objects.equals(numbers, numbers1.numbers);
	}
}

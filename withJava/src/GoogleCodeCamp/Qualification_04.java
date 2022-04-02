package GoogleCodeCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Qualification_04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String modules = br.readLine();
			ModuleG[] moduleGArray = new ModuleG[N];

			StringTokenizer moduleSt = new StringTokenizer(modules);
			for (int j = 0; j < N; j++) {
				int amount = Integer.parseInt(moduleSt.nextToken());
				moduleGArray[j] = new ModuleG(amount);
			}

			String chains = br.readLine();
			StringTokenizer chainSt = new StringTokenizer(chains);
			for (int j = 0; j < N; j++) {
				int prevCursor = Integer.parseInt(chainSt.nextToken());
				ModuleG moduleG = moduleGArray[j];
				if (prevCursor != 0) {
					ModuleG toModule = moduleGArray[prevCursor - 1];
					moduleG.nextModule = toModule;
					toModule.prevModule.add(moduleG);
				} else {
					moduleG.isFinal = true;
				}
			}

			Arrays.sort(moduleGArray, Comparator.comparingInt(c -> c.amountFun));
			List<ModuleG> moduleGList = Arrays.asList(moduleGArray);

			solution(moduleGList);
			// System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}

	private static int solution(List<ModuleG> moduleGList) {
		int ans = 0;
		List<ModuleG> initList = moduleGList.stream()
			.filter(moduleG -> moduleG.isInitializer())
			.sorted(new Comparator<ModuleG>() {
				@Override
				public int compare(ModuleG m1, ModuleG m2) {
					return Integer.compare(m1.amountFun, m2.amountFun);
				}
			})
			.collect(Collectors.toList());

		for (ModuleG moduleG : initList) {
			moduleG.chain();
		}

		return ans;
	}
}

class ModuleG {
	List<ModuleG> prevModule = new ArrayList<>();
	ModuleG nextModule;
	int amountFun;
	boolean isFinal = false;
	boolean isUsed = false;

	public ModuleG(int amountFun) {
		this.amountFun = amountFun;
	}

	public boolean isInitializer() {
		return prevModule.isEmpty();
	}

	public int chain() {
		return nextModule.chain(amountFun);
	}

	private int chain(int amountFun) {
		if (isUsed) {
			return nextModule.chain(amountFun);
		}

		if (this.amountFun < amountFun) {
			this.amountFun = amountFun;
		}

		if (isFinal) {
			return this.amountFun;
		}
		isUsed = true;
		return nextModule.chain(this.amountFun);
	}
}

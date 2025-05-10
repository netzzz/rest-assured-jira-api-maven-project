package data;

import utils.EncryptionUtil;

public class JiraApiData {
	public static String returnAuthorizationToken() throws Exception{
		String encryptedToken = "G1U5wAeaUlehPjgSM2/UvpduQNpEkewNsnPNC4y3kwTE1851dMPHGvSmPkRwYHDMQ6IwThJ81Xch/xn6EXZB8Jz"
				+ "5wzmNmiEUFkbNs4uoncTqH8CYysmv+0soRuJ9AgAXMCeJsqvfuhtrZqY4N7cFsCg8B6wNS5Mb1w62CQMvw98/7L/LUStuk7logPzL"
				+ "OrL0ePWEqW52QQPSk55Ls0s6UMpAmu56Nj7rWSRfWUdS9ruljMMNhDesXjIXi/YXilP4eMDbwUiu/J61ZzJne5FOhGbyyG5fGxpNG"
				+ "S4aH4t/+2lzMjxMGCD7VcIPSPiyXAsIg8VmDZ5Y3v/jV/b5njwYmznwkH1TapJsA6Vt8TUXisUPRUoCYKaMg5fx7T6B5kdmgHOX3C"
				+ "OY3k1XEK/sctS5mAjkw+BW6U0vjljlZZKp0mo=";

		return EncryptionUtil.decrypt(encryptedToken);
	}
}

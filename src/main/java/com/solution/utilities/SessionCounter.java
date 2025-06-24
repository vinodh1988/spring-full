package com.solution.utilities;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionCounter {
	 private int count = 0;

		public int getCount() {
			return count;
		}

		public void increment() {
			count++;
		}

		public void reset() {
			count = 0;
		}
}

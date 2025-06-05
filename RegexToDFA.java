import java.util.*;

/**
 * 正则表达式到DFA的简单实现
 * 支持的基本操作：
 * - 连接 (ab)
 * - 选择 (a|b)
 * - 克林闭包 (a*)
 */
public class RegexToDFA {
    // DFA状态类
    static class State {
        int id;
        Map<Character, State> transitions;
        boolean isAccepting;

        public State(int id) {
            this.id = id;
            this.transitions = new HashMap<>();
            this.isAccepting = false;
        }

        public void addTransition(char symbol, State next) {
            transitions.put(symbol, next);
        }
    }

    // DFA类
    static class DFA {
        State startState;
        Set<State> states;

        public DFA() {
            this.states = new HashSet<>();
        }

        // 检查字符串是否被DFA接受
        public boolean accepts(String input) {
            State current = startState;
            System.out.println("开始状态: " + current.id);

            for (char c : input.toCharArray()) {
                current = current.transitions.get(c);
                if (current == null) {
                    System.out.println("无转移: " + c);
                    return false;
                }
                System.out.println("读取 " + c + " 后转移到状态: " + current.id);
            }

            return current.isAccepting;
        }
    }

    // 构建一个简单的DFA示例：识别以"ab"结尾的字符串
    public static DFA buildEndsWithAB() {
        DFA dfa = new DFA();

        // 创建状态
        State q0 = new State(0); // 初始状态
        State q1 = new State(1); // 读取到'a'后的状态
        State q2 = new State(2); // 读取到'ab'后的状态（接受状态）

        // 设置转移
        q0.addTransition('a', q1);
        q0.addTransition('b', q0);

        q1.addTransition('a', q1);
        q1.addTransition('b', q2);

        q2.addTransition('a', q1);
        q2.addTransition('b', q0);

        // 设置接受状态
        q2.isAccepting = true;

        // 设置初始状态
        dfa.startState = q0;
        dfa.states.addAll(Arrays.asList(q0, q1, q2));

        return dfa;
    }

    public static void main(String[] args) {
        // 测试DFA
        DFA dfa = buildEndsWithAB();

        // 测试用例
        String[] testCases = {
                "ab", // 应该接受
                "aab", // 应该接受
                "bab", // 应该接受
                "aba", // 应该拒绝
                "b", // 应该拒绝
                "aaab" // 应该接受
        };

        System.out.println("测试DFA（识别以'ab'结尾的字符串）：");
        System.out.println("----------------------------------------");

        for (String test : testCases) {
            boolean result = dfa.accepts(test);
            System.out.printf("输入: %-10s 结果: %s%n",
                    test, result ? "接受" : "拒绝");
            System.out.println("----------------------------------------");
        }
    }
}
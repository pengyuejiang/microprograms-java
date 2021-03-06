/*
 * 成功了！
 * 而且还挺快的，效率还不错。
 * 但是有一个小bug
 * 每一次都会有两个格子还是0。
 * 不清楚原因。
 * 下次更新的时候再算一遍来解决。
 * 最后，庆祝一下
 * 四小时内完成的项目
 */
/*
 * 更新日志：第一次更新，V2
 * 本次更新目标：
 * 1. 消除bug
 * 2. 提高算法效率（优化算法）
 * 3. 体现数据封装
 * 4. 重新命名变量
 */
/*
 * 更新日志：第二次更新，V3
 * 本次更新目标：
 * 1. 模块化算法
 * 2. 分解元素
 */
public class SudokuV3 {
	
	// 主方法：
	public static void main(String[] args) {
		Core.collectData();
		Core.generate();
		// 计算：
		// 只要全场有一个0就不停止计算：
		// 用来判断什么时候终止计算的变量：
		boolean solved = false;
		while (!solved) {
			// 算法装载区：
			
			EliminationAlgorithm.run();
			
			// 用来判断什么时候停止：
			outter: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// 只要发现一个0就不改变解决状态，继续做：
					if (Core.sg[i][j].value == 0) {
						break outter;
					}
					// 如果检查到最后一个并且其值不为0，改变解决状态：
					if (i == 8 && j == 8 && Core.sg[8][8].value != 0) {
						solved = true;
					}
				}
			}
		}
		/*
		 * 我知道了，可能是因为我用break没有break外面的循环
		 * 应该在外循环加outter标签
		 * 问题解决了
		*/
		System.out.println();
		Core.display();
	}
	
}
/*
 * 完成的改进：
 * 1. 删除了V1中没有用的isZero方法
 * 2. 美化了display()的效果
 * 3. 将solved变成局部变量，提高效率
 * 4. 增加了instruction的明确性
 * 5. 解决了bug
 */
// 突然发现当难度提升到Medium这个算法就不够用了
// 在第二次更新完了之后，看上去更加模块化了，扩展也方便了许多
// 下一步是封装——更加体现面向对象编程特点
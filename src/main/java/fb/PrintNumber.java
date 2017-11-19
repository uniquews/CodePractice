package fb;

public class PrintNumber {
    /**
     * 开始上题 ： 三姐在墙上写题， 一边写一边介绍。 说给你一个API， 传入的是char，
     * 然后可以将这个char打印出来。 我刚开始以为， 返回值也是char, 跟三姐交谈后她说不是，
     * 调用这个API只是把char在console里面打印出来，没有返回值。   然后她让我写个方法，
     * 把一个integer 打印出来， 这个integer是非负数。 我说也是void么？ 她说是的。
     * 当时感觉这题有点非主流，不过还好 心里一直在默念move fast， 赶紧写码， 我用的是String.valueOf()把int转成string，
     * 然后再把string转成char array， 然后loop 调用API 把char打出来。。 写完之后， 三姐说。 不行， 不能变成String再换成char。
     * 卧槽， 当时有点蒙圈， 再想他到底想要什么。停顿了几分钟， 三姐给我一个hint，说如果输入的integer只是一个single digit 你咋做？
     * 我说可以用ascii码转换，她说yes, 1在ascii里对应的是几 。。 （尼玛。。。。这个我忘了 回来一查是49) 她看我没说出来， 说先不谈这个，你继续写吧。。
     * 然后我通过她给的hint， 恍然大悟， 就是把一个数字从高位到低位依次输出， 再通过ascii码转换，  调用API打印。 我就写了个从高位到低位打印数字的方法，
     * 之前没写过这个。写完了让我逐行解释，并把每次循环变量的值列出来， 后来她挑出了bug,   100这个case 过不了。  然后我就再改， 背后在冒凉汗，
     * 本来ascii码那个就卡壳了， 现在又有bug, 还只做了一题。 改完到时间了， 三姐都没拍照，，我知道我要再见了。
     *
     * */
    public String printNumber(int num) {
        int base = 1;
        while (base * 10 <= num) {
            base *= 10;
        }

        StringBuilder sb = new StringBuilder();
        while (base != 0) {
            sb.append((char)(num / base + '0'));
            num %= base;
            base /= 10;
        }
        return sb.toString();
    }
}

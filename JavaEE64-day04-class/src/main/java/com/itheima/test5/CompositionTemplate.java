package com.itheima.test5;

public abstract class CompositionTemplate {
    public final void write() {
        System.out.println("<<我的爸爸>>");

        body();

        System.out.print(",啊这是我的爸爸. 作者:张三");
    }

    protected abstract void body();

}

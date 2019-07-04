package cn.edu.hdu.ibatis.SqlSession;

public interface SqlSession {
    /**
     * 反射生成对象
     * @param daoInterface
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterface);

    void close();
}

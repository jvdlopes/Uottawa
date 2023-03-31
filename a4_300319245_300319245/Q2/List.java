public interface List<E> {
    void addFirst(E elem);
    int size();
    E get(int index);
    Iterator<E> iterator();
}

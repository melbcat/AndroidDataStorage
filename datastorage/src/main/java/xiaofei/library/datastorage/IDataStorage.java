package xiaofei.library.datastorage;

import java.util.Comparator;
import java.util.List;

import xiaofei.library.datastorage.util.Condition;
/**
 * Created by Eric on 16/3/24.
 *
 * This interface defines basic functions of the data storage.
 *
 * Programmers use the implementation of this interface to use the storage.
 *
 */
public interface IDataStorage {

    /**
     * Return true if the storage contains the element of the specified class and the specified id, false otherwise.
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    <T> boolean contains(Class<T> clazz, String id);

    /**
     * Return true if the storage contains the element, false otherwise.
     * The element should have one and only one field of the String type on which the ObjectId annotation is present.
     * @param element
     * @param <T>
     * @return
     */
    <T> boolean contains(T element);

    /**
     * Store or update an element of the specified id.
     * If the storage previously contained one element of the same id, the old one is replaced by the new one.
     * Otherwise, the storage stores the element.
     * @param element
     * @param id
     * @param <T>
     */
    <T> void storeOrUpdate(T element, String id);

    /**
     * Store or update an element.
     * The element should have one and only one field of the String type on which the ObjectId annotation is present.
     * If the storage previously contained one element of the same id, the old one is replaced by the new one.
     * Otherwise, the storage stores the element.
     * @param element
     * @param <T>
     */
    <T> void storeOrUpdate(T element);

    /**
     * Store or update a list of elements of the same type.
     * Each element has a corresponding id at the corresponding position in the list ids.
     * The two lists should be of the same size.
     * @param list
     * @param ids
     * @param <T>
     */
    <T> void storeOrUpdate(List<T> list, List<String> ids);

    /**
     * Store or update a list of elements of the same type.
     * The elements should have one and only one field of the String type on which the ObjectId annotation is present.
     * @param list
     * @param <T>
     */
    <T> void storeOrUpdate(List<T> list);

    /**
     * Return the element of the specified class and the specified id.
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    <T> T load(Class<T> clazz, String id);

    /**
     * Return a list of all the elements of the specified class.
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> loadAll(Class<T> clazz);

    <T> List<T> loadAll(Class<T> clazz, Comparator<T> comparator);

    /**
     * Return a list of elements of the specified class and the specified ids.
     * Each element has a corresponding id at the corresponding position in the list ids.
     * @param clazz
     * @param ids
     * @param <T>
     * @return
     */
    <T> List<T> load(Class<T> clazz, List<String> ids);

    <T> List<T> load(Class<T> clazz, List<String> ids, Comparator<T> comparator);

    /**
     * Return a list of elements which satisfying the condition.
     * @param clazz
     * @param condition
     * @param <T>
     * @return
     */
    <T> List<T> load(Class<T> clazz, Condition<T> condition);

    <T> List<T> load(Class<T> clazz, Condition<T> condition, Comparator<T> comparator);

    /**
     * Delete the element.
     * The element should have one and only one field of the String type on which the ObjectId annotation is present.
     * @param element
     * @param <T>
     */
    <T> void delete(T element);

    /**
     * Delete the element of the specified class and the specified id.
     * @param clazz
     * @param id
     * @param <T>
     */
    <T> void delete(Class<T> clazz, String id);

    /**
     * Delete all the elements of the specified class;
     */
    <T> void deleteAll(Class<T> clazz);

    /**
     * Delete the elements of the specified class and the id in the list ids.
     * @param clazz
     * @param ids
     * @param <T>
     */
    <T> void delete(Class<T> clazz, List<String> ids);

    /**
     * Delete the elements in the list.
     * The elements should have one and only one field of the String type on which the ObjectId annotation is present.
     * @param list
     * @param <T>
     */
    <T> void delete(List<T> list);

    <T> void delete(Class<T> clazz, Condition<T> condition);

    /**
     * Clear all the data in the storage.
     */
    void clear();
}

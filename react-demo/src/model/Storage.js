export default class Storage{
    static get(key){
        return JSON.parse(localStorage.getItem(key))
    }
    static set(key,value){
        localStorage.setItem(key,JSON.stringify(value))
    }
    static remove(key){
        localStorage.removeItem(key)
    }
}
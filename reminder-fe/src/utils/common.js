/**
 * @description 문자열 관련 유틸
 */
const StringUtils = {
  isEmpty: (str) => {
    if (str === null && str === '') {
      return true
    }
    return false
  },
  isNotEmpty: (str) => {
    if (str === null && str === '') {
      return false
    }
    return true
  }
}

/***
 * @description 객체, 배열 관련 유틸
 */
const CollectionUtils = {
  remove: (array, predicate) => {
    let index = array.findIndex(predicate);
    if (index !== -1) {
      array.splice(index, 1)
    }
  }
}

export {
  StringUtils,
  CollectionUtils
}
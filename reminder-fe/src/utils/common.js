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

export {
  StringUtils
}
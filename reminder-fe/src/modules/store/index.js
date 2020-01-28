import Vue from 'vue'
import Vuex from 'vuex'

import member from './domain/member'
import publisher from './domain/publisher'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    member,
    publisher
  },
  // true 일 시 state가 mutation 외부에서 변경될 시 오류 발생 -> 개발단계에서 state를 명시적으로 추적, 관리할 수 있음
  // 하지만 이 기능을 위해 상태트리를 자세히 관찰하기 때문에 성능 이슈가 있을 수 있어서 서비스 환경에서는 false로 설정
  strict: debug
})
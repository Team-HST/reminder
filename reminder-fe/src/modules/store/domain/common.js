const state = {
  layout: 'single-layout' 
}

const getters = {}

const mutations = {
  /** 
   * @param state state 객체
   * @param layout 변경 레이아웃
   * @description 레이아웃 조회
   */
  setLayout: (state, layout) => {
    state.layout = layout
  }
}

const actions = {}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
import codeService from '@/modules/service/codeService'

const state = {
  codeMap: {}
}

const getters = {}

const mutations = {
  setCodeMap: (state, codeMap) => {
    state.codeMap = codeMap
  }
}

const actions = {
  initCodeMap({commit}) {
    codeService.getCodes().then(response => {
      let codeMap = {}
      response.data.forEach(codeInfo => {
        codeMap[codeInfo['codeGroup']] = codeInfo['codes']
      })
      commit('setCodeMap', codeMap)
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
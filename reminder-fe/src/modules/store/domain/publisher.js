import publisherService from '@/modules/service/publisherService'

const state = {
  publishers: []
}

const getters = {
  getPublishers() {
    return state.publishers;
  }
}

const mutations = {
  setPublishers(state, publishers) {
    state.publishers = publishers;
  }
}

const actions = {
  getPublishers({ commit }, memberId) {
    publisherService(memberId).then((response) => { 
      response.data.publishers.forEach((e) => console.log(e))
      commit('setPublishers', response.data.publishers);
    }).catch((e) => console.error(e))
  }
}

export default {
  // 네임스페이스로 분할화된 모듈 처리
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
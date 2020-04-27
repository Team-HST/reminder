import channelService from '@/modules/service/channelService'

const state = {
  createdChannels: [],
  involvedChannels: []
}

const mutations = {
  setCreatedChannels(state, createdChannels) {
    state.createdChannels = createdChannels;
  }
}

const getters = {
}

const actions = {
  async getCreatedChannels({ commit }, memberId) {
    let response = await channelService.getCreatedChannels(memberId);
    commit('setCreatedChannels', response.data.channels);
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
import channelService from '@/modules/service/channelService'

const state = {
  channels: {
    created: [],
    involved: []    
  }
}

const mutations = {
  setCreatedChannels(state, createdChannels) {
    state.channels.created = createdChannels;
  },
  setInvolvedChannels(state, involvedChannels) {
    state.channels.involved = involvedChannels;
  }
}

const getters = {
}

const actions = {
  async getCreatedChannels({ commit }, memberId) {
    let response = await channelService.getCreatedChannels(memberId);
    commit('setCreatedChannels', response.data.channels);
  },
  async getInvolvedChannels({ commit }, memberId) {
    let response = await channelService.getInvolvedChannels(memberId);
    commit('setInvolvedChannels', response.data.channels);
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
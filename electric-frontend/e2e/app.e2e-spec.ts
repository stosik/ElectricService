import { ElectricFrontendPage } from './app.po';

describe('electric-frontend App', () => {
  let page: ElectricFrontendPage;

  beforeEach(() => {
    page = new ElectricFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
